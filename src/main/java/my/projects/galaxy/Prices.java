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

  public BigDecimal totalFor(String good, Long units) {
    return pricesByGood.get(good).multiply(new BigDecimal(units));
  }

  private BigDecimal unitaryPrice(BigDecimal credits, Long units) {
    return credits.divide(new BigDecimal(units));
  }

}
