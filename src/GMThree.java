import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class GMThree {
    public static void main(String[] args)
    {
        System.out.println("Enter the amount of purchase: ");
        Scanner in = new Scanner(System.in);
        //Taking the amount of purchase
        BigDecimal pp = new BigDecimal(in.next());
        System.out.println("Enter the amount of cash: ");
        //Taking the amount of cash received from the customer
        BigDecimal ch = new BigDecimal(in.next());
        //The currency exists in these numbers for more than one Dollar
        BigInteger[] discreteCurrencyAboveOne = new BigInteger[6];
        discreteCurrencyAboveOne[0] = BigInteger.valueOf(50);
        discreteCurrencyAboveOne[1] = BigInteger.valueOf(20);
        discreteCurrencyAboveOne[2] = BigInteger.valueOf(10);
        discreteCurrencyAboveOne[3] = BigInteger.valueOf(5);
        discreteCurrencyAboveOne[4] = BigInteger.valueOf(2);
        discreteCurrencyAboveOne[5] = BigInteger.valueOf(1);
        //The currency exists in these numbers for less than one Dollar
        BigDecimal[] discreteCurrencyBelowOne = new BigDecimal[5];
        discreteCurrencyBelowOne[0] = BigDecimal.valueOf(0.5);
        discreteCurrencyBelowOne[1] = BigDecimal.valueOf(0.25);
        discreteCurrencyBelowOne[2] = BigDecimal.valueOf(0.1);
        discreteCurrencyBelowOne[3] = BigDecimal.valueOf(0.05);
        discreteCurrencyBelowOne[4] = BigDecimal.valueOf(0.01);
        //Names of discrete currency values for less than one Dollar
        HashMap<BigDecimal, String> nameOfCurrencyBelowOne = new HashMap<>();
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.01), "Penny");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.05), "Nickel");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.1), "Dime");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.25), "Quarter");
        nameOfCurrencyBelowOne.put(BigDecimal.valueOf(0.5), "Half");
        //Names of discrete currency values for more than one Dollar
        HashMap<BigInteger, String> nameOfCurrencyAboveOne = new HashMap<>();
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(1), "Loonie");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(2), "Toonie");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(5), "Five");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(10), "Ten");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(20), "Twenty");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(50), "Fifty");
        nameOfCurrencyAboveOne.put(BigInteger.valueOf(100), "Hundred");
        //Calculation of the change
        BigDecimal difference = ch.subtract(pp);
        if (difference.compareTo(BigDecimal.valueOf(0.0)) < 0)
        {
            System.out.println("ERROR!");
        }
        else if (difference.compareTo(BigDecimal.valueOf(0.0)) == 0)
        {
            System.out.println("ZERO!");
        }
        //If the change is bigger than zero, below calculations are applied
        else
        {
            //Numbers on the left side of and the right side of the point are separated and kept as BigIntegers
            //So, we get rid of the point and simply work with BigIntegers in order to use mod operation
            BigInteger left = difference.toBigInteger();
            difference = difference.subtract(new BigDecimal(left));
            BigInteger right = difference.multiply(BigDecimal.valueOf(100.0)).toBigInteger();
            //Left side of the point is treated
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
            //Right side of the point is treated
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
            //The result is printed out
            for(BigInteger i : firstRes.getResult().keySet())
            {
                System.out.println(firstRes.getResult().get(i) + " x " + nameOfCurrencyAboveOne.get(i));
            }
            for(BigDecimal j : secondRes.getResult().keySet())
            {
                System.out.println(secondRes.getResult().get(j) + " x " + nameOfCurrencyBelowOne.get(j));
            }
        }
    }
}
