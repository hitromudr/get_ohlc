import org.scalatest.FlatSpec

class CandleTest_2_Invalid_ScalaTest extends FlatSpec {

    var cc = new Candle()

    behavior of "get_ohlc"

    it should "return 0,0,0,0 in case of get_ohlc(\"reset\") - initializing" in {
        assertResult((0, 0, 0, 0)) {
            cc.get_ohlc("reset")
        }
    }

    it should "return 7,7,7,7 initialized by get_ohlc(7)" in {
        assertResult((7, 7, 7, 7)) {
            cc.get_ohlc(7)
        }
    }
    it should "return 7,7,7,7 in case of get_ohlc(-1) - ignore negative values" in {
        assertResult((7, 7, 7, 7)) {
            cc.get_ohlc(-1)
        }
    }
    it should "return 7,7,7,7 in case of get_ohlc(1.0) - we treat float as invalid data for simplicity" in {
        assertResult((7, 7, 7, 7)) {
            cc.get_ohlc(1.0)
        }
    }
    it should "return 7,7,7,7 in case of get_ohlc(\"invalid text data\") - ignore text not equal to reset" in {
        assertResult((7, 7, 7, 7)) {
            cc.get_ohlc("invalid text data")
        }
    }
    it should "return 7,7,7,7 in case of get_ohlc(\"invalid data with special symbols $#%&^?*_\\\") - ignore special characters" in {
        assertResult((7, 7, 7, 7)) {
            cc.get_ohlc("invalid data with special symbols $#%&^?*_\\")
        }
    }
}
