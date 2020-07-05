package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Prices;
import my.projects.galaxy.Result;

public class HowManyCreditsGoodsQuery implements Action {

  private Result result;
  private Prices prices;

  public HowManyCreditsGoodsQuery(Prices prices, Result result) {
    this.prices = prices;
    this.result = result;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("how many Credits is (?<words>.+) (?<good>\\w+) ?");
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
