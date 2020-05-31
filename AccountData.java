 import java.io.*;
/**
* This class represents data of type Account,
* each object have  Ticker, Date, Open, High, Low, Cloes and Volume
*/

public class AccountData implements Serializable
{
    public String ticker;
    public int date, volume;
    public float open, high, low, close;

	 /**
   * Constructor, which creates an object of AccountData
   * @param String ticker.
   * @param int date.
   * @param float open.
   * @param float high.
   * @param float low.
   * @param float close.
   * @param int volume.
   * @return Nothing.
   */
    public AccountData(String ticker, int date, float open, float high, float low, float close , int volume)
    {
        this.ticker = ticker;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

	 /**
   * This compares two object of AccountData on basis of their "Ticker"
   * @param AccountData data .
   * @return int comparision.
   */
    public int compareTo(AccountData k)
    {
		// data is less than k
        if(this.ticker.compareTo(k.ticker) < 0)
            return -1;
		// data is greater than k
        else if(this.ticker.compareTo(k.ticker) > 0)
            return 1;
		// data is equal to k 
        else
            return 0;
    }

	 /**
   * This is toString() of our custom dataType AccountData
   * @param nothing .
   * @return String account.
   */
    public String toString()
    {
        return ticker+", "+date+", "+open+", "+high+", "+low+", "+close+", "+volume+"\n";
    }
}