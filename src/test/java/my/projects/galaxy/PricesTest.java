package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class PricesTest {

  private Translations translations;

  @Before
  public void setUp() {
    translations = new ArabicTranslations();
    translations.meaning("one", "1");
  }

  @Test
  public void exact() {
    Prices prices = new Prices(translations).add(10L, "Silver", "one");

    assertThat(prices.compute("Silver", "one"), is(10L));
  }

  @Test
  public void multiple() throws Exception {
    Prices prices = new Prices(translations).add(10L, "Silver", "one");

    assertThat(prices.compute("Silver", "one", "one"), is(110L));
  }

}
