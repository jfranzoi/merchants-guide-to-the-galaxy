package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class RomanNumeralsTest {

  private RomanNumerals numerals = new RomanNumerals();

  @Test
  public void singleSymbols() {
    assertThat(numerals.compute(Arrays.asList("I")), is(1L));
    assertThat(numerals.compute(Arrays.asList("V")), is(5L));
    assertThat(numerals.compute(Arrays.asList("X")), is(10L));
    assertThat(numerals.compute(Arrays.asList("L")), is(50L));
    assertThat(numerals.compute(Arrays.asList("C")), is(100L));
    assertThat(numerals.compute(Arrays.asList("D")), is(500L));
    assertThat(numerals.compute(Arrays.asList("M")), is(1000L));
  }

  @Test
  public void multipleSymbolsAdded() throws Exception {
    assertThat(numerals.compute(Arrays.asList("V", "I")), is(6L));
    assertThat(numerals.compute(Arrays.asList("X", "V", "I")), is(16L));
  }

  @Test
  @Ignore("WIP")
  public void multipleSymbolsSubtracted() throws Exception {
    assertThat(numerals.compute(Arrays.asList("X", "L", "I", "I")), is(42L));
    assertThat(numerals.compute(Arrays.asList("M", "C", "M", "X", "L", "I", "V")), is(1944L));
  }

}
