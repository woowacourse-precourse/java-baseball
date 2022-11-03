package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void concat_문자열_뒤에_문자열_추가하기() {
        String input = "Hello";
        String result = input.concat(" World!");

        assertThat(result).isEqualTo("Hello World!");
    }

    @Test
    void contains_문자열을_포함하고_있는지_확인() {
        String input = "Choi Seungwon";

        assertThat(input.contains("Choi")).isEqualTo(true);
    }

    @Test
    void endsWith_문자열이_지정된_문자열로_끝나는지_확인() {
        String input = "wonny@email.com";

        assertThat(input.endsWith("@email.com")).isEqualTo(true);
    }

    @Test
    void replaceAll_지정된_문자열과_일치하는_모든_문자열_변경() {
        String input = "AAABBBABAB";
        String result = "AAAbbbAbAb";

        assertThat(input.replaceAll("B", "b"));
    }

}