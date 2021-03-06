package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Translations;
import my.projects.galaxy.io.Result;

public class HowMuchWordsQuery implements Action {

  private Translations translations;
  private Result result;

  public HowMuchWordsQuery(Translations translations, Result result) {
    this.translations = translations;
    this.result = result;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile("how much is (?<words>.+) \\?");
  }

  @Override
  public void process(Matcher matcher) {
    result.add(String.format(
        "%s is %s",
        matcher.group("words"),
        translate(matcher.group("words"))));
  }

  private Long translate(String words) {
    return translations.translate(words);
  }

}
