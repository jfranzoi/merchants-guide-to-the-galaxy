package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import my.projects.galaxy.dummies.FileFixture;

public class FileContentTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  private File source;

  @Before
  public void setUp() throws Exception {
    source = folder.newFile();
  }

  @Test
  public void testNoLines() throws Exception {
    List<String> lines = new ArrayList<>();
    new FileContent(source).onEachLine(x -> lines.add(x));

    assertThat(lines, empty());
  }

  @Test
  public void testWithLines() throws Exception {
    new FileFixture(source)
        .append("glob means I")
        .append("how much is pish tegj glob glob ?")
        .save();

    List<String> lines = new ArrayList<>();
    new FileContent(source).onEachLine(x -> lines.add(x));

    assertThat(lines, contains("glob means I", "how much is pish tegj glob glob ?"));
  }

}
