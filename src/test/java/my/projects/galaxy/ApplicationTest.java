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
        .append("one means 1")
        .append("five means 5")
        .append("ten means 10")
        .append("fifty means 50")
        .append("how much is ten fifty one one ?");

    application().process(content, result);

    assertThat(result.output(), contains("ten fifty one one is 105011"));
  }

  @Test
  public void understandsUnits() throws Exception {
    content
        .append("one means 1")
        .append("one units of Silver are worth 10 Credits")
        .append("how many Credits is one one Silver ?");

    application().process(content, result);

    assertThat(result.output(), contains("one one Silver is 110 Credits"));
  }

  @Test
  public void invalidQueries() throws Exception {
    content.append("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

    application().process(content, result);

    assertThat(result.output(), contains("I have no idea what you are talking about"));
  }

  private Application application() {
    return new Application(new Translations(new ArabicNumerals()), new Prices());
  }

}
