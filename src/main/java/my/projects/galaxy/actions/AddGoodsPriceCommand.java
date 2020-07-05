package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Translations;
import my.projects.galaxy.Prices;

public class AddGoodsPriceCommand implements Action {

  private Translations translations;
  private Prices prices;

  public AddGoodsPriceCommand(Translations translations, Prices prices) {
    this.translations = translations;
    this.prices = prices;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("(?<units>.+) units of (?<good>\\w+) are worth (?<credits>\\d+) Credits");
  }

  @Override
  public void process(Matcher matcher) {
    prices.add(asNumber(matcher.group("credits")), matcher.group("good"), translate(matcher.group("units")));
  }

  private Long translate(String words) {
    return translations.translate(words.split(" "));
  }

  private Long asNumber(String text) {
    return Long.valueOf(text);
  }

}
