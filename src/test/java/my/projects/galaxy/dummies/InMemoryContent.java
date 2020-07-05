package my.projects.galaxy.dummies;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import my.projects.galaxy.Content;

public class InMemoryContent implements Content {

  private List<String> lines = new ArrayList<String>();

  public InMemoryContent append(String line) {
    lines.add(line);
    return this;
  }

  @Override
  public void onEachLine(Consumer<String> action) {
    lines.forEach(action);
  }

}
