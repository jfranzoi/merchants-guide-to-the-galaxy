package my.projects.galaxy;

import java.util.function.Consumer;

public interface Content {

  void onEachLine(Consumer<String> action);

}
