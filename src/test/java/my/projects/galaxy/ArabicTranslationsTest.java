package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ArabicTranslationsTest {

  @Test
  public void single() {
    Translations translations = new ArabicTranslations().meaning("one", "1");

    assertThat(translations.compute("one"), is(1L));
  }

  @Test
  public void repeated() throws Exception {
    Translations translations = new ArabicTranslations().meaning("one", "1");

    assertThat(translations.compute("one", "one"), is(11L));
  }

  @Test
  public void different() throws Exception {
    Translations translations = new ArabicTranslations()
        .meaning("one", "1")
        .meaning("five", "5")
        .meaning("ten", "10");

    assertThat(translations.compute("one", "five"), is(15L));
    assertThat(translations.compute("five", "ten"), is(510L));
  }

}
