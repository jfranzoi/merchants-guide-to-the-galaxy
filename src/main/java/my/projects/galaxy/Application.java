package my.projects.galaxy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import my.projects.galaxy.actions.AddGoodsPriceCommand;
import my.projects.galaxy.actions.AddWordsMeaningCommand;
import my.projects.galaxy.actions.FallbackAction;
import my.projects.galaxy.actions.HowManyCreditsGoodsQuery;
import my.projects.galaxy.actions.HowMuchWordsQuery;

public class Application {

  public static void main(String[] args) {
    new Application().process(
        new FileContent(new File(args[0])),
        (x) -> System.out.println(x));
  }

  private Translations translations;
  private Prices prices;

  public Application() {
    this(new Translations(new RomanNumerals()), new Prices());
  }

  public Application(Translations translations, Prices prices) {
    this.translations = translations;
    this.prices = prices;
  }

  public void process(Content content, Result result) {
    content.onEachLine(x -> {
      process(x, result);
    });
  }

  private void process(String line, Result result) {
    for (Action action : actionsOn(result)) {
      Matcher matcher = matcherOn(action, line);
      if (matcher.find()) {
        action.process(matcher);
        return;
      }
    }
  }

  private Matcher matcherOn(Action action, String line) {
    return action.pattern().matcher(line);
  }

  private List<Action> actionsOn(Result result) {
    return Arrays.asList(
        new AddWordsMeaningCommand(translations),
        new AddGoodsPriceCommand(translations, prices),
        new HowMuchWordsQuery(translations, result),
        new HowManyCreditsGoodsQuery(translations, prices, result),
        new FallbackAction(result));
  }

}
