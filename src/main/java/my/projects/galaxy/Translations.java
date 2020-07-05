package my.projects.galaxy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Translations {

  private final Map<String, String> symbolsByWord = new HashMap<String, String>();

  public Translations meaning(String word, String symbol) {
    symbolsByWord.put(word, symbol);
    return this;
  }

  public Long compute(String... words) {
    return toNumber(asDigits(words));
  }

  private String asDigits(String... words) {
    return Stream.of(words)
        .map(x -> symbolFor(x))
        .collect(Collectors.joining());
  }

  private String symbolFor(String word) {
    return symbolsByWord.get(word);
  }

  private Long toNumber(String symbol) {
    return Long.valueOf(symbol);
  }

}
