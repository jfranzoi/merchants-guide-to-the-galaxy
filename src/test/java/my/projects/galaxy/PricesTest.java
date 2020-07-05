package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;

import org.junit.Test;

public class PricesTest {

  @Test
  public void exact() {
    Prices prices = new Prices().add(new BigDecimal("57800"), "Gold", 4L);

    assertThat(prices.compute("Gold", 4L), is(new BigDecimal("57800")));
  }

  @Test
  public void multiple() throws Exception {
    Prices prices = new Prices().add(new BigDecimal("34"), "Silver", 2L);

    assertThat(prices.compute("Silver", 4L), is(new BigDecimal("68")));
  }

  @Test
  public void decimals() throws Exception {
    Prices prices = new Prices().add(new BigDecimal("3910"), "Iron", 20L);

    assertThat(prices.compute("Iron", 4L), is(new BigDecimal("782.0")));
  }

}
