package playground.string;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * SearchingTest
 */
public class SearchingTest {

    @Test
    public void linearSearch() {
        assertThat(Searching.linealSearch("", ""), is(0));
        assertThat(Searching.linealSearch("a", "a"), is(0));
        assertThat(Searching.linealSearch("abcde", "bc"), is(1));
        assertThat(Searching.linealSearch("abcdeef", "deef"), is(3));
        assertThat(Searching.linealSearch("abeee", "eeee"), is(-1));
    }

    @Test
    public void boyerMooreSearch() {
        assertThat(Searching.boyerMooreSearch("", ""), is(-1));
        assertThat(Searching.boyerMooreSearch("a", "a"), is(0));
        assertThat(Searching.boyerMooreSearch("abcde", "bc"), is(1));
        assertThat(Searching.boyerMooreSearch("abcdeef", "deef"), is(3));
        assertThat(Searching.boyerMooreSearch("abeee", "eeee"), is(-1));
    }
}
