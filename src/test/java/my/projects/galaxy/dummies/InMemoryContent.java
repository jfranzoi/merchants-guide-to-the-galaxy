package my.projects.galaxy.dummies;

import java.util.ArrayList;
import java.util.List;

import my.projects.galaxy.Content;

public class InMemoryContent implements Content {

  private List<String> lines = new ArrayList<String>();

  public InMemoryContent append(String line) {
    lines.add(line);
    return this;
  }

  @Override
  public List<String> lines() {
    return lines;
  }

}
