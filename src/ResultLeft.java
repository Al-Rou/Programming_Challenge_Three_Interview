import java.math.BigInteger;
import java.util.HashMap;

public class ResultLeft {
    private HashMap<BigInteger, BigInteger> result;

    public HashMap<BigInteger, BigInteger> getResult() {
        return result;
    }

    public void setResult(BigInteger k, BigInteger v) {
        result.put(k, v);
    }
}
