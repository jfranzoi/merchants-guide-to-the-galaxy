package my.projects.galaxy.io;

public class ConsoleResult implements Result {

  @Override
  public void add(String line) {
    System.out.println(line);
  }

}
