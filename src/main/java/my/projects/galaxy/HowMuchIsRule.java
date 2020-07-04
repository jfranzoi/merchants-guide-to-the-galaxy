package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowMuchIsRule implements Rule {

  private static final Pattern PATTERN = Pattern.compile("how much is (?<words>.+) \\?");

  private Translations translations;
  private Result result;

  public HowMuchIsRule(Translations translations, Result result) {
    this.translations = translations;
    this.result = result;
  }

  @Override
  public Pattern pattern() {
    return PATTERN;
  }

  @Override
  public void process(Matcher matcher) {
    result.add(String.format(
        "%s is %s",
        matcher.group("words"),
        translations.compute(matcher.group("words").split(" "))));
  }

}
