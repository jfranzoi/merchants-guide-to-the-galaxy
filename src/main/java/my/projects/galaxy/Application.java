package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  private Translations translations;

  public Application() {
    this(new ArabicTranslations());
  }

  public Application(Translations translations) {
    this.translations = translations;
  }

  public void process(Content content, Result result) {
    content.lines().forEach(x -> {
      process(x, result);
    });
  }

  private void process(String line, Result result) {

    Matcher means = Pattern.compile("(?<word>\\w+) means (?<symbol>\\w+)").matcher(line);
    Matcher howMuch = Pattern.compile("how much is (?<words>.+) \\?").matcher(line);

    if (means.find()) {
      translations.meaning(means.group("word"), means.group("symbol"));
    } else if (howMuch.find()) {
      result.add(String.format(
        "%s is %s",
        howMuch.group("words"),
        translations.compute(howMuch.group("words").split(" "))
      ));
    } else {
      result.add("I have no idea what you are talking about");
    }
  }

}
