import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

public class ResultRight {
    private HashMap<BigDecimal, BigInteger> result;

    public HashMap<BigDecimal, BigInteger> getResult() {
        return result;
    }

    public void setResult(BigDecimal k, BigInteger v) {
        result.put(k, v);
    }
}
