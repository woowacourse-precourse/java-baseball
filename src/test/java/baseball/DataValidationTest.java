package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataValidationTest {

    @Test
    void 입력의_길이가_3인지_검증() {
        String input = "1234";
        int inputLength = input.length();

        assertThat(inputLength).isNotEqualTo(3);
    }

    @Test
    void 입력에_숫자_외에_다른_문자가_있는지_검증() {
        String input = "123";

        assertThat(input).containsOnlyDigits();
    }

    @Test
    void 입력에_동일한_숫자가_존재하는지_확인() {
        String input = "123";
        char[] inputArr = input.toCharArray();

        assertThat(inputArr[0]).isNotEqualTo(inputArr[1]);
        assertThat(inputArr[1]).isNotEqualTo(inputArr[2]);
        assertThat(inputArr[0]).isNotEqualTo(inputArr[2]);
    }
}
