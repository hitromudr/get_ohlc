import scala.util.Random

class Candle {
    private var o, h, l, c = 0
    private var reset = true

    // FUNCTION TO TEST
    // for simplicity we evaluate only positive integer numbers and ignore the rest
    def get_ohlc[T](value: T): (Int, Int, Int, Int) = {
        value match {
            case str: String if str.toLowerCase == "reset" =>
                o = 0; h = 0; l = 0; c = 0; reset = true
            case int: Int
                if int > 0 => {
                    o = get_o(value.asInstanceOf[Int])
                    h = get_h(value.asInstanceOf[Int])
                    l = get_l(value.asInstanceOf[Int])
                    c = get_c(value.asInstanceOf[Int])
                    reset = false
                }
            case _ => {}
        }
        //Emulating random delay 0 to 20 ms
        Thread.sleep(new Random().nextInt(20));
        (o, h, l, c)
    }

    //Get current values for test purpose
    def get_ohlc_current(): (Int, Int, Int, Int) = {
        (o, h, l, c)
    }

    private def get_o(value: Int): Int = if(reset) value else o
    private def get_h(value: Int): Int = if(value > h) value else h
    private def get_l(value: Int): Int = if(reset) value else if(value < l) value else l
    private def get_c(value: Int): Int = value
}
