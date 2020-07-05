package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.io.Result;

public class FallbackCommand implements Action {

  private Result result;

  public FallbackCommand(Result result) {
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
