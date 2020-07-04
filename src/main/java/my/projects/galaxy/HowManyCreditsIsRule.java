package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowManyCreditsIsRule implements Rule {

  private static final Pattern PATTERN = Pattern.compile("how many Credits is (?<words>.+) (?<good>\\w+) ?");

  private Result result;
  private Prices prices;

  public HowManyCreditsIsRule(Prices prices, Result result) {
    this.prices = prices;
    this.result = result;
  }

  @Override
  public Pattern pattern() {
    return PATTERN;
  }

  @Override
  public void process(Matcher matcher) {
    result.add(String.format(
        "%s %s is %s Credits",
        matcher.group("words"),
        matcher.group("good"),
        prices.compute(matcher.group("good"), matcher.group("words").split(" "))));
  }

}
