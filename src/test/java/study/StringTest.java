package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void separatedBySplit() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void noneSeparatedTest() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void findByCharAt() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void exceptionFindByCharAt() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
