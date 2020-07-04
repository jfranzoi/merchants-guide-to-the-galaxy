package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ArabicTranslationsTest {

  @Test
  public void single() {
    Translations translations = new ArabicTranslations().meaning("glob", "1");

    assertThat(translations.compute("glob"), is(1L));
  }

  @Test
  public void repeated() throws Exception {
    Translations translations = new ArabicTranslations().meaning("glob", "1");

    assertThat(translations.compute("glob", "glob"), is(11L));
  }

  @Test
  public void different() throws Exception {
    Translations translations = new ArabicTranslations().meaning("glob", "1").meaning("prok", "5");

    assertThat(translations.compute("glob", "prok"), is(15L));
    assertThat(translations.compute("prok", "glob"), is(51L));
  }

}
