package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FallbackRule implements Rule {

  private Result result;

  public FallbackRule(Result result) {
    this.result = result;
  }

  @Override
  public Pattern pattern() {
    return Pattern.compile(".*");
  }

  @Override
  public void process(Matcher matcher) {
    result.add("I have no idea what you are talking about");
  }

}
