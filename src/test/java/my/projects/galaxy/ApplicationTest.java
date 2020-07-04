package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;
import org.junit.Test;

import my.projects.galaxy.dummies.InMemoryContent;
import my.projects.galaxy.dummies.InMemoryResult;

public class ApplicationTest {

  private InMemoryContent content;
  private InMemoryResult result;

  @Before
  public void setUp() {
    result = new InMemoryResult();
    content = new InMemoryContent();
  }

  @Test
  public void understandNumbers() {
    content
        .append("glob means 1")
        .append("prok means 5")
        .append("pish means 10")
        .append("tegj means 50")
        .append("how much is pish tegj glob glob ?");

    new Application(new ArabicTranslations()).process(content, result);

    assertThat(result.output(), contains("pish tegj glob glob is 15011"));
  }

  @Test
  public void understandsUnits() throws Exception {
    content
        .append("glob means 1")
        .append("glob units of Silver are worth 10 Credits")
        .append("how many Credits is glob glob Silver ?");

    new Application(new ArabicTranslations()).process(content, result);

    assertThat(result.output(), contains("glob glob Silver is 110 Credits"));
  }

  @Test
  public void invalidQueries() throws Exception {
    content.append("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

    new Application(new ArabicTranslations()).process(content, result);

    assertThat(result.output(), contains("I have no idea what you are talking about"));
  }

}
