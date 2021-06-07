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
        BigInteger[] discreteCurrencyAboveOne = new BigInteger[6];
        discreteCurrencyAboveOne[0] = BigInteger.valueOf(50);
        discreteCurrencyAboveOne[1] = BigInteger.valueOf(20);
        discreteCurrencyAboveOne[2] = BigInteger.valueOf(10);
        discreteCurrencyAboveOne[3] = BigInteger.valueOf(5);
        discreteCurrencyAboveOne[4] = BigInteger.valueOf(2);
        discreteCurrencyAboveOne[5] = BigInteger.valueOf(1);
        BigDecimal[] discreteCurrencyBelowOne = new BigDecimal[5];
        discreteCurrencyBelowOne[0] = BigDecimal.valueOf(0.5);
        discreteCurrencyBelowOne[1] = BigDecimal.valueOf(0.25);
        discreteCurrencyBelowOne[2] = BigDecimal.valueOf(0.1);
        discreteCurrencyBelowOne[3] = BigDecimal.valueOf(0.05);
        discreteCurrencyBelowOne[4] = BigDecimal.valueOf(0.01);
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
            ResultLeft firstRes = new ResultLeft();
            for (int i = 0; i < 6; i++)
            {
                if(left.divide(discreteCurrencyAboveOne[i]).compareTo(BigInteger.valueOf(0)) != 0)
                {
                    BigInteger quotient = left.divide(discreteCurrencyAboveOne[i]);
                    left = left.mod(discreteCurrencyAboveOne[i]);
                    firstRes.setResult(discreteCurrencyAboveOne[i], quotient);
                }
            }
            ResultRight secondRes = new ResultRight();
            for (int i = 0; i < 5; i++)
            {
                if (right.divide(discreteCurrencyBelowOne[i].multiply(BigDecimal.valueOf(100.0)).toBigInteger()).compareTo(BigInteger.valueOf(0)) != 0)
                {
                    BigInteger quotient = right.divide(discreteCurrencyBelowOne[i].multiply(BigDecimal.valueOf(100.0)).toBigInteger());
                    right = right.mod(discreteCurrencyBelowOne[i].multiply(BigDecimal.valueOf(100.0)).toBigInteger());
                    secondRes.setResult(discreteCurrencyBelowOne[i], quotient);
                }
            }
        }
    }
}
