package my.projects.galaxy.dummies;

import java.util.List;
import java.util.stream.Collectors;

import my.projects.galaxy.Numerals;

public class ArabicNumerals implements Numerals {

  @Override
  public Long compute(List<String> symbols) {
    return toNumber(join(symbols));
  }

  private String join(List<String> symbols) {
    return symbols.stream().collect(Collectors.joining());
  }

  private Long toNumber(String symbol) {
    return Long.valueOf(symbol);
  }

}
