import io.gatling.commons.stats.{KO, OK}
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.core.action.{Action, ChainableAction}
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.stats.message.ResponseTimings
import io.gatling.core.structure.ScenarioContext

import scala.language.postfixOps
import scala.util.Random

class CandleTest_4_Load_Gatling extends Simulation{
    val cc = new Candle()
    //initialize get_ohlc for testing purpose
    cc.get_ohlc("reset")
    cc.get_ohlc(500)

    val scn = scenario("CandleTest_3_Load")
                 .exec(new CandleAB("get_ohlc(value)"))
    setUp(
        scn.inject(atOnceUsers(500))
    )

    class CandleAB(myNameAction: String) extends ActionBuilder {
        override def build(ctx: ScenarioContext, next: Action): Action = {
            new CandleCA(myNameAction, next, ctx)
        }
    }

    class CandleCA(myNameAction: String, myNextAction: Action, ctx: ScenarioContext) extends ChainableAction {
        override def next: Action = myNextAction
        override def name: String = myNameAction
        override def execute(mySession: Session): Unit = {
            val cur_result = cc.get_ohlc_current()
            val startTime = System.currentTimeMillis()
            try {
                val rnd = new Random().nextInt(10000)
                val result = cc.get_ohlc(rnd)
                val stopTime = System.currentTimeMillis()
                //checking proper get_ohlc(value) work
                if (   result._1 != cur_result._1
                    || result._2 < cur_result._2
                    || result._3 > cur_result._3
                    || result._4 != rnd   )
                        throw new RuntimeException("Test failed")
                //emulating random 5% fails for better overal picture
                //comment this code to see real picture
                if (new Random().nextInt(100) < 5) throw new RuntimeException("Test failed")
                ctx.coreComponents.statsEngine.logResponse(
                    session = mySession,
                    requestName = name,
                    timings = ResponseTimings(startTime, stopTime),
                    status = OK,
                    None,
                    None,
                    Nil
                )
                myNextAction ! mySession
            }
            catch {
                case e: Exception => {
                    val stopTime = System.currentTimeMillis()

                    ctx.coreComponents.statsEngine.logResponse(
                        session = mySession,
                        requestName = name,
                        timings = ResponseTimings(startTime, stopTime),
                        status = KO,
                        None,
                        Some(e.getMessage),
                        Nil
                    )
                    myNextAction ! mySession
                }
            }
        }
    }
}