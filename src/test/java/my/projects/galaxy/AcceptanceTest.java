package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

public class AcceptanceTest {

  @Test
  @Ignore("WIP")
  public void completeExample() {

    Application application = new Application();

    application.process(
        "glob​ means ​I",
        "prok​ means ​V",
        "pish​ means ​X",
        "tegj​ means ​L",
        "glob glob​ units of ​Silver​ are worth ​34 Credits",
        "glob prok​ units of ​Gold​ are worth ​57800 Credits",
        "pish pish​ units of ​Iron​ are worth ​3910 Credits"
    );

    assertThat(application.process("how much is pish tegj glob glob ?"), is("pish tegj glob glob is 42"));
    assertThat(application.process("how many Credits is glob prok Silver ?"), is("glob prok Silver is 68 Credits"));
    assertThat(application.process("how many Credits is glob prok Gold ?"), is("glob prok Gold is 57800 Credits"));
    assertThat(application.process("how many Credits is glob prok Iron ?"), is("glob prok Iron is 782 Credits"));
    assertThat(application.process("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"), is("I have no idea what you are talking about"));
  }

}
