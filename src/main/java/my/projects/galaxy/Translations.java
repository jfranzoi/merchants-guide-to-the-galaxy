package my.projects.galaxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Translations {

  private Map<String, String> symbolsByWord = new HashMap<String, String>();
  private Numerals numerals;

  public Translations(Numerals numerals) {
    this.numerals = numerals;
  }

  public Translations meaning(String word, String symbol) {
    symbolsByWord.put(word, symbol);
    return this;
  }

  public Long translate(String words) {
    return numerals.compute(toSymbols(words.split(" ")));
  }

  private List<String> toSymbols(String... words) {
    return Stream.of(words)
        .map(x -> toSymbol(x))
        .collect(Collectors.toList());
  }

  private String toSymbol(String word) {
    return symbolsByWord.get(word);
  }

}
