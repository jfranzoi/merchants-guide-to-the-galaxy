package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ArabicTranslations implements Translations {

  private final Map<String, String> symbolsByWord = new HashMap<String, String>();

  @Override
  public Translations meaning(String word, String symbol) {
    symbolsByWord.put(word, symbol);
    return this;
  }

  @Override
  public Long compute(String... words) {
    return Stream.of(words).map(x -> numberFor(x)).reduce(0L, (x, y) -> compute(x, y));
  }

  private Long compute(Long left, Long right) {
    return right + (left * 10);
  }

  private Long numberFor(String word) {
    return toNumber(symbolsByWord.get(word));
  }

  private Long toNumber(String symbol) {
    return Long.valueOf(symbol);
  }

}
