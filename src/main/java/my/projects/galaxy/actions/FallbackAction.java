package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.projects.galaxy.Action;
import my.projects.galaxy.Result;

public class FallbackAction implements Action {

  private Result result;

  public FallbackAction(Result result) {
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
