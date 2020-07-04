package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeaningRule implements Rule {

  private Translations translations;

  public MeaningRule(Translations translations) {
    this.translations = translations;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("(?<word>\\w+) means (?<symbol>\\w+)");
  }

  @Override
  public void process(Matcher matcher) {
    translations.meaning(matcher.group("word"), matcher.group("symbol"));
  }

}
