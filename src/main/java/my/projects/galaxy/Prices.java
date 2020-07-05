package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;

public class Prices {

  private Map<String, Long> pricesByGood = new HashMap<String, Long>();

  public Prices add(Long credits, String good, Long units) {
    pricesByGood.put(good, unitaryPrice(credits, units));
    return this;
  }

  public Long compute(String good, Long price) {
    return pricesByGood.get(good) * price;
  }

  private long unitaryPrice(Long credits, Long units) {
    return credits / units;
  }

}
