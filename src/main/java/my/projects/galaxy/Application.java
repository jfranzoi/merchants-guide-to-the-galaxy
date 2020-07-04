package my.projects.galaxy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Application {

  private Translations translations;
  private Prices prices;

  public Application() {
    this(new ArabicTranslations());
  }

  public Application(Translations translations) {
    this.translations = translations;
    this.prices = new Prices(translations);
  }

  public void process(Content content, Result result) {
    content.lines().forEach(x -> {
      process(x, result);
    });
  }

  private void process(String line, Result result) {
    for (Rule rule : rules(result)) {
      Matcher matcher = rule.pattern().matcher(line);
      if (matcher.find()) {
        rule.process(matcher);
        return;
      }
    }
  }

  private List<Rule> rules(Result result) {
    return Arrays.asList(
        new MeaningRule(translations),
        new UnitsOfRule(prices),
        new HowMuchIsRule(translations, result),
        new HowManyCreditsIsRule(prices, result),
        new FallbackRule(result));
  }

}
