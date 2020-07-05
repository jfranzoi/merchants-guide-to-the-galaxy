package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Translations;

public class AddWordsMeaningCommand implements Action {

  private Translations translations;

  public AddWordsMeaningCommand(Translations translations) {
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
