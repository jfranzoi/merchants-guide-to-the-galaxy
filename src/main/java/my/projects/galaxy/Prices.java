package my.projects.galaxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Prices {

  private Map<String, BigDecimal> pricesByGood = new HashMap<>();

  public Prices add(Long credits, String good, Long units) {
    pricesByGood.put(good, unitaryPrice(credits, units));
    return this;
  }

  public BigDecimal compute(String good, Long price) {
    return pricesByGood.get(good).multiply(new BigDecimal(price));
  }

  private BigDecimal unitaryPrice(Long credits, Long units) {
    return new BigDecimal(credits).divide(new BigDecimal(units));
  }

}
