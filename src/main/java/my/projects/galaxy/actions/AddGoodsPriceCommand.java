package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Prices;

public class AddGoodsPriceCommand implements Action {

  private Prices prices;

  public AddGoodsPriceCommand(Prices prices) {
    this.prices = prices;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("(?<words>.+) units of (?<good>\\w+) are worth (?<credits>\\d+) Credits");
  }

  @Override
  public void process(Matcher matcher) {
    prices.add(asNumber(matcher.group("credits")), matcher.group("good"), matcher.group("words").split(" "));
  }

  private Long asNumber(String text) {
    return Long.valueOf(text);
  }

}
