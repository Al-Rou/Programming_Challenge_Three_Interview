import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class GMThree {
    public static void main(String[] args)
    {
        System.out.println("Enter the amount of purchase: ");
        Scanner in = new Scanner(System.in);
        BigDecimal pp = new BigDecimal(in.next());
        System.out.println("Enter the amount of cash: ");
        BigDecimal ch = new BigDecimal(in.next());
        BigDecimal[] discreteCurrencyBelowOne = new BigDecimal[11];
        discreteCurrency[0] = BigDecimal.valueOf(50.0);
        discreteCurrency[1] = BigDecimal.valueOf(20.0);
        discreteCurrency[2] = BigDecimal.valueOf(10.0);
        discreteCurrency[3] = BigDecimal.valueOf(5.0);
        discreteCurrency[4] = BigDecimal.valueOf(2.0);
        discreteCurrency[5] = BigDecimal.valueOf(1.0);
        discreteCurrency[6] = BigDecimal.valueOf(0.5);
        discreteCurrency[7] = BigDecimal.valueOf(0.25);
        discreteCurrency[8] = BigDecimal.valueOf(0.1);
        discreteCurrency[9] = BigDecimal.valueOf(0.05);
        discreteCurrency[10] = BigDecimal.valueOf(0.01);
        HashMap<BigDecimal, String> nameOfCurrencyBelowOne = new HashMap<>();
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.01), "Penny");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.05), "Nickel");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.1), "Dime");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.25), "Quarter");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.5), "Half");
        HashMap<BigInteger, String> nameOfCurrencyAboveOne = new HashMap<>();
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(1), "Loonie");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(2), "Toonie");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(5), "Five");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(10), "Ten");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(20), "Twenty");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(50), "Fifty");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(100), "Hundred");
        BigDecimal difference = ch.subtract(pp);
        if (difference.compareTo(BigDecimal.valueOf(0.0)) < 0)
        {
            System.out.println("ERROR!");
        }
        else if (difference.compareTo(BigDecimal.valueOf(0.0)) == 0)
        {
            System.out.println("ZERO!");
        }
        else
        {
            BigInteger left = difference.toBigInteger();
            difference = difference.subtract(new BigDecimal(left));
            BigInteger right = difference.multiply(BigDecimal.valueOf(100.0)).toBigInteger();
            //System.out.println(left);
            //System.out.println(right);
            for (int i = 0; i < 6; i++)
            {
                if(left.divide(discreteCurrency[i]).compareTo(BigDecimal.valueOf(0.0)) != 0)
                {
                    BigDecimal quotient = difference.divide(discreteCurrency[i]);
                }
            }
        }
    }
}
