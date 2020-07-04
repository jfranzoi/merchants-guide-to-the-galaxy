package my.projects.galaxy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileContent implements Content {

  private File source;

  public FileContent(File source) {
    this.source = source;
  }

  public List<String> lines() {
    return linesAt(source);
  }

  private List<String> linesAt(File file) {
    try {
      return Files.readAllLines(Paths.get(file.getAbsolutePath()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
