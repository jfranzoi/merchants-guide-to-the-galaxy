package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Translations;
import my.projects.galaxy.Prices;
import my.projects.galaxy.Result;

public class HowManyCreditsGoodsQuery implements Action {

  private Translations translations;
  private Prices prices;
  private Result result;

  public HowManyCreditsGoodsQuery(Translations translations, Prices prices, Result result) {
    this.translations = translations;
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
        priceFor(matcher.group("good"), translate(matcher.group("words")))));
  }

  private Long translate(String words) {
    return translations.compute(words.split(" "));
  }

  private Long priceFor(String good, Long words) {
    return prices.compute(good, words);
  }

}
