package my.projects.galaxy.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileContent implements Content {

  private File source;

  public FileContent(File source) {
    this.source = source;
  }

  @Override
  public void onEachLine(Consumer<String> action) {
    try (Stream<String> lines = Files.lines(Paths.get(source.getAbsolutePath()))) {
      lines.forEach(action);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
