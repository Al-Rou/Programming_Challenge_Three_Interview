import java.math.BigDecimal;
import java.util.*;

public class GMThree {
    public static void main(String[] args)
    {
        System.out.println("Enter the amount of purchase: ");
        Scanner in = new Scanner(System.in);
        BigDecimal pp = new BigDecimal(in.next());
        System.out.println("Enter the amount of cash: ");
        BigDecimal ch = new BigDecimal(in.next());
        int[] discreteCurrency = new int[4];
        discreteCurrency[0] = 50;
        discreteCurrency[1] = 20;
        discreteCurrency[2] = 10;
        discreteCurrency[3] = 25;
        HashMap<BigDecimal, String> nameOfCurrency = new HashMap<>();
        nameOfCurrency.put(BigDecimal.valueOf(0.01), "Penny");
        nameOfCurrency.put(BigDecimal.valueOf(0.05), "Nickel");
        nameOfCurrency.put(BigDecimal.valueOf(0.1), "Dime");
        nameOfCurrency.put(BigDecimal.valueOf(0.25), "Quarter");
        nameOfCurrency.put(BigDecimal.valueOf(0.5), "Half");
        nameOfCurrency.put(BigDecimal.valueOf(1.0), "Loonie");
        nameOfCurrency.put(BigDecimal.valueOf(2.0), "Toonie");
        nameOfCurrency.put(BigDecimal.valueOf(5.0), "Five");
        nameOfCurrency.put(BigDecimal.valueOf(10.0), "Ten");
        nameOfCurrency.put(BigDecimal.valueOf(20.0), "Twenty");
        nameOfCurrency.put(BigDecimal.valueOf(50.0), "Fifty");
        nameOfCurrency.put(BigDecimal.valueOf(100.0), "Hundred");
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
            System.out.println("OK");
        }
    }
}
