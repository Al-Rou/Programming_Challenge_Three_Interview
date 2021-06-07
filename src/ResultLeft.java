import java.math.BigInteger;
import java.util.HashMap;

//This class keeps the result of calculations for the left side of the point of the difference
public class ResultLeft {
    //In this HashMap, the key is discreteCurrencyAboveOne and the value is the number of them
    private HashMap<BigInteger, BigInteger> result;

    public ResultLeft()
    {
        result = new HashMap<>();
    }

    public HashMap<BigInteger, BigInteger> getResult() {
        return result;
    }

    public void setResult(BigInteger k, BigInteger v) {
        result.put(k, v);
    }
}
