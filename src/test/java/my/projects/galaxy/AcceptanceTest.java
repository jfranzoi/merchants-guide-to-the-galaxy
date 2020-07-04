package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import my.projects.galaxy.dummies.FileFixture;
import my.projects.galaxy.dummies.InMemoryResult;

public class AcceptanceTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  private File merchants;
  private InMemoryResult result;

  @Before
  public void setUp() throws Exception {
    merchants = folder.newFile("merchants.txt");
    result = new InMemoryResult();
  }

  @Test
  @Ignore("WIP")
  public void completeExample() throws Exception {

    new FileFixture(merchants)
        .append("glob​ means ​I")
        .append("prok​ means ​V")
        .append("pish​ means ​X")
        .append("tegj​ means ​L")
        .append("glob glob​ units of ​Silver​ are worth ​34 Credits")
        .append("glob prok​ units of ​Gold​ are worth ​57800 Credits")
        .append("pish pish​ units of ​Iron​ are worth ​3910 Credits")
        .append("how much is pish tegj glob glob ?")
        .append("how many Credits is glob prok Silver ?")
        .append("how many Credits is glob prok Gold ?")
        .append("how many Credits is glob prok Iron ?")
        .append("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?")
        .save();

    new Application().process(new FileContent(merchants), result);

    assertThat(result.output(), contains(
        "pish tegj glob glob is 42",
        "glob prok Silver is 68 Credits",
        "glob prok Gold is 57800 Credits",
        "glob prok Iron is 782 Credits",
        "I have no idea what you are talking about"));
  }

}
