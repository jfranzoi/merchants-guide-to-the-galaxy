package my.projects.galaxy.dummies;

import java.util.ArrayList;
import java.util.List;

import my.projects.galaxy.Result;

public class InMemoryResult implements Result {

  private List<String> output = new ArrayList<String>();

  public List<String> output() {
    return output;
  }

  @Override
  public void add(String line) {
    output.add(line);
  }

}
