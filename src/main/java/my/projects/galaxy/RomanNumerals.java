package my.projects.galaxy;

import java.util.HashMap;
import java.util.List;

public class RomanNumerals implements Numerals {

  private static HashMap<String, Long> DEFAULTS = new HashMap<String, Long>() {
    {
      put("I", 1L);
      put("V", 5L);
      put("X", 10L);
      put("L", 50L);
    }
  };

  @Override
  public Long compute(List<String> symbols) {
    return symbols.stream().findFirst()
        .map(x -> compute(x))
        .orElse(0L);
  }

  private Long compute(String symbol) {
    return DEFAULTS.get(symbol);
  }

}
