package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Prices;
import my.projects.galaxy.Translations;

public class AddGoodsPriceCommand implements Action {

  private Translations translations;
  private Prices prices;

  public AddGoodsPriceCommand(Translations translations, Prices prices) {
    this.translations = translations;
    this.prices = prices;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("(?<words>.+) units of (?<good>\\w+) are worth (?<credits>\\d+) Credits");
  }

  @Override
  public void process(Matcher matcher) {
    prices.add(asNumber(matcher.group("credits")), matcher.group("good"), translate(matcher.group("words")));
  }

  private Long translate(String words) {
    return translations.compute(words.split(" "));
  }

  private Long asNumber(String text) {
    return Long.valueOf(text);
  }

}