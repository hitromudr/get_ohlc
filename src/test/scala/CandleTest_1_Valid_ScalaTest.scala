import org.scalatest.FlatSpec

class CandleTest_1_Valid_ScalaTest extends FlatSpec {

    var cc = new Candle()

    behavior of "get_ohlc"

    it should "return 0,0,0,0 in case of get_ohlc(\"reset\") - initializing" in {
        assertResult((0, 0, 0, 0)) {
            cc.get_ohlc("reset")
        }
    }
    it should "return 5,5,5,5 in case of get_ohlc(5)" in {
        assertResult((5, 5, 5, 5)) {
            cc.get_ohlc(5)
        }
    }
    it should "return 5,9,5,9 in case of get_ohlc(9)" in {
        assertResult((5, 9, 5, 9)) {
            cc.get_ohlc(9)
        }
    }
    it should "return 5,9,1,1 in case of get_ohlc(1)" in {
        assertResult((5, 9, 1, 1)) {
            cc.get_ohlc(1)
        }
    }
    it should "return 0,0,0,0 in case of get_ohlc(\"RESET\")" in {
        assertResult((0, 0, 0, 0)) {
            cc.get_ohlc("RESET")
        }
    }
    it should "return 3,3,3,3 in case of get_ohlc(3)" in {
        assertResult((3,3,3,3)) {
            cc.get_ohlc(3)
        }
    }
    it should "return 3,99,3,99 in case of get_ohlc(99)" in {
        assertResult((3,99,3,99)) {
            cc.get_ohlc(99)
        }
    }
    it should "return 3,99,2,2 in case of get_ohlc(2)" in {
        assertResult((3,99,2,2)) {
            cc.get_ohlc(2)
        }
    }
}