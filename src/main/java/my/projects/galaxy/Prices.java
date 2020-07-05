package my.projects.galaxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Prices {

  private Map<String, BigDecimal> pricesByGood = new HashMap<>();

  public Prices add(BigDecimal credits, String good, Long units) {
    pricesByGood.put(good, unitaryPrice(credits, units));
    return this;
  }

  public BigDecimal compute(String good, Long price) {
    return pricesByGood.get(good).multiply(new BigDecimal(price));
  }

  private BigDecimal unitaryPrice(BigDecimal credits, Long units) {
    return credits.divide(new BigDecimal(units));
  }

}
