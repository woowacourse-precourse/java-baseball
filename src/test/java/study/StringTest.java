package study;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
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
    void regex_test_correct(){

        final Pattern NUMBER_PATTERN = Pattern.compile("([1-9][1-9][1-9])$");

        String userInput = "111";

        boolean target = NUMBER_PATTERN.matcher(userInput).matches();

        assertThat(target).isEqualTo(true);
    }


    @Test
    void regex_test_stat_zero_case(){

        final Pattern NUMBER_PATTERN = Pattern.compile("([0-9][1-9][1-9])$");

        String userInput = "011";

        boolean target = NUMBER_PATTERN.matcher(userInput).matches();

        assertThat(target).isEqualTo(true);
    }

    @Test
    void regex_test_state_differnt_patter_case(){

        final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]{1,3}$");

        String userInput = "000";

        boolean target = NUMBER_PATTERN.matcher(userInput).matches();

        assertThat(target).isEqualTo(true);
    }
    @Test
    void regex_test_state_differnt_patter_case_one(){

        final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]{1,3}$");

        String userInput = "111"; // case 111 , 123 ,222 ~ 999

        boolean target = NUMBER_PATTERN.matcher(userInput).matches();

        assertThat(target).isEqualTo(true);
    }

    @DisplayName("Stream test")
    @Test
    void regex_text_state(){
        IntStream.range(0,4).forEach
                (i -> {
                    if (i % 2 == 0) {
                        System.out.println("1");
                    }
                    if (i % 2 == 1 ){
                        System.out.println("2");
                    }
                }
        );




    }

}
