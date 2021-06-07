import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

//This class keeps the result of calculations for the right side of the point of the difference
public class ResultRight {
    //In this HashMap, the key is discreteCurrencyBelowOne and the value is the number of them
    private HashMap<BigDecimal, BigInteger> result;

    public ResultRight()
    {
        result = new HashMap<>();
    }

    public HashMap<BigDecimal, BigInteger> getResult() {
        return result;
    }

    public void setResult(BigDecimal k, BigInteger v) {
        result.put(k, v);
    }
}
