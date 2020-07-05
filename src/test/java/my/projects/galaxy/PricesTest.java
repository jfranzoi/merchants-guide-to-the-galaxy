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
    Prices prices = new Prices().add(10L, "Silver", 1L);

    assertThat(prices.compute("Silver", 1L), is(10L));
  }

  @Test
  public void multiple() throws Exception {
    Prices prices = new Prices().add(10L, "Silver", 1L);

    assertThat(prices.compute("Silver", 11L), is(110L));
  }

}
