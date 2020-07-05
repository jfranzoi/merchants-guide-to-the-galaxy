package my.projects.galaxy;

import java.util.HashMap;
import java.util.List;

public class RomanNumerals implements Numerals {

  private static HashMap<String, Long> VALUES = new HashMap<String, Long>() {
    {
      put("I", 1L);
      put("V", 5L);
      put("X", 10L);
      put("L", 50L);
      put("C", 100L);
      put("D", 500L);
      put("M", 1000L);
    }
  };

  @Override
  public Long compute(List<String> symbols) {
    return symbols.stream()
        .map(x -> compute(x))
        .reduce(0L, (x, y) -> add(x, y));
  }

  private Long compute(String symbol) {
    return VALUES.get(symbol);
  }

  private Long add(Long first, Long second) {
    return first + second;
  }

}
