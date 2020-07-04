package my.projects.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Rule {

  Pattern pattern();

  void process(Matcher matcher);

}
