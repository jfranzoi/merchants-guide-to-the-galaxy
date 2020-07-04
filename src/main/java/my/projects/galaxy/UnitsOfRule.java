package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitsOfRule implements Rule {

  private static final Pattern PATTERN = Pattern.compile("(?<words>.+) units of (?<good>\\w+) are worth (?<credits>\\d+) Credits");
  private Prices prices;

  public UnitsOfRule(Prices prices) {
    this.prices = prices;
  }

  @Override
  public Pattern pattern() {
    return PATTERN;
  }

  @Override
  public void process(Matcher matcher) {
    prices.add(asNumber(matcher.group("credits")), matcher.group("good"), matcher.group("words").split(" "));
  }

  private Long asNumber(String text) {
    return Long.valueOf(text);
  }

}
