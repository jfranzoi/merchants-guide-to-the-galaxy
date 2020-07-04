package my.projects.galaxy;

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
    if (line.contains(" means ")) {
      String word = line.split(" means ")[0];
      String value = line.split(" means ")[1];
      translations.meaning(word, value);
    } else if (line.contains("how much is ")) {
      String text = line.split("how much is ")[1].replace(" ?", "");
      Long value = translations.compute(text.split(" "));
      result.add(String.format("%s is %s", text, value));
    }
  }

}
