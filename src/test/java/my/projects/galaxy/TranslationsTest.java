package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import my.projects.galaxy.dummies.ArabicNumerals;

public class TranslationsTest {

  @Test
  public void single() {
    Translations translations = new Translations(new ArabicNumerals()).meaning("one", "1");

    assertThat(translations.translate("one"), is(1L));
  }

  @Test
  public void repeated() throws Exception {
    Translations translations = new Translations(new ArabicNumerals()).meaning("one", "1");

    assertThat(translations.translate("one one"), is(11L));
  }

  @Test
  public void different() throws Exception {
    Translations translations = new Translations(new ArabicNumerals())
        .meaning("one", "1")
        .meaning("five", "5")
        .meaning("ten", "10");

    assertThat(translations.translate("one five"), is(15L));
    assertThat(translations.translate("five ten"), is(510L));
  }

}
