package my.projects.galaxy.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Action {

  Pattern pattern();

  void process(Matcher matcher);

}
