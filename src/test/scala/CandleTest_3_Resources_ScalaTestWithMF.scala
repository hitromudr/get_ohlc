import org.scalatest.FlatSpec
import com.sun.management.OperatingSystemMXBean
import java.lang.management.ManagementFactory
import scala.util.Random

class CandleTest_3_Resources_ScalaTestWithMF extends FlatSpec{

    var cc = new Candle()
    val mf = ManagementFactory.getOperatingSystemMXBean.asInstanceOf[OperatingSystemMXBean]
    // memory info
    val mb = 1024*1024
    val runtime = Runtime.getRuntime

    var cpuUsage = (mf.getProcessCpuLoad * 100).toInt
    var metricCount = 1
    behavior of "get_ohlc"

    it should "run 1000 cycles of loop for data collection" in {
        for(i <- 0 to 1000) {
            cc.get_ohlc(new Random().nextInt(1000))
            if (i % 50 == 0){
                cpuUsage += (mf.getProcessCpuLoad * 100).toInt
                metricCount += 1
            }
        }
    }
    info("** JVM Used Memory:    " + (runtime.totalMemory - runtime.freeMemory) / mb + " Mb")
    info("** JVM Free Memory:    " + runtime.freeMemory / mb + " Mb")
    info("** JVM Total Memory:   " + runtime.totalMemory / mb + " Mb")
    info("** JVM Max Memory:     " + runtime.maxMemory / mb + " Mb")
    info("** Average CPU Usage:  " + cpuUsage / metricCount + " %")
    info("** Process CPU Time :  " + (mf.getProcessCpuTime / 1000000).toInt + " ms")
}
