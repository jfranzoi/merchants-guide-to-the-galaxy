package my.projects.galaxy.io;

import java.util.function.Consumer;

public interface Content {

  void onEachLine(Consumer<String> action);

}
