package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;
import org.junit.Test;

import my.projects.galaxy.dummies.InMemoryResult;
import my.projects.galaxy.dummies.InMemoryContent;

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

}
