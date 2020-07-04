package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;

public class Prices {

  private Translations translations;
  private Map<String, Long> pricesByGood = new HashMap<String, Long>();

  public Prices(Translations translations) {
    this.translations = translations;
  }

  public Prices add(Long credits, String good, String... words) {
    pricesByGood.put(good, unitaryPrice(credits, words));
    return this;
  }

  public Long compute(String good, String... words) {
    return pricesByGood.get(good) * translations.compute(words);
  }

  private long unitaryPrice(Long credits, String... words) {
    return credits / translations.compute(words);
  }

}
