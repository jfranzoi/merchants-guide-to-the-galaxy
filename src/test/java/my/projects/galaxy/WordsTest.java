package my.projects.galaxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class WordsTest {

    @Test
    public void single() {
	Words words = new Words().meaning("glob", "1");

	assertThat(words.compute("glob"), is(1L));
    }

    @Test
    public void repeated() throws Exception {
	Words words = new Words().meaning("glob", "1");

	assertThat(words.compute("glob", "glob"), is(11L));
    }
    
    @Test
    public void different() throws Exception {
	Words words = new Words().meaning("glob", "1").meaning("prok", "5");

	assertThat(words.compute("glob", "prok"), is(15L));
	assertThat(words.compute("prok", "glob"), is(51L));
    }

}
