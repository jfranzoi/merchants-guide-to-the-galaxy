package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.Test;

public class RomanNumeralsTest {

  @Test
  public void defaultSymbols_I() {
    assertThat(new RomanNumerals().compute(Arrays.asList("I")), is(1L));
  }
  
  @Test
  public void defaultSymbols_V() {
    assertThat(new RomanNumerals().compute(Arrays.asList("V")), is(5L));
  }

  @Test
  public void defaultSymbols_X() {
    assertThat(new RomanNumerals().compute(Arrays.asList("X")), is(10L));
  }
  
  @Test
  public void defaultSymbols_L() {
    assertThat(new RomanNumerals().compute(Arrays.asList("L")), is(50L));
  }
  
  
}
