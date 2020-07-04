package my.projects.galaxy.dummies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileFixture {

  private File source;
  private List<String> lines;

  public FileFixture(File source) {
    this.source = source;
    this.lines = new ArrayList<String>();
  }

  public FileFixture append(String line) {
    lines.add(line);
    return this;
  }

  public void save() throws Exception {
    Files.write(Paths.get(source.getAbsolutePath()), lines);
  }

}
