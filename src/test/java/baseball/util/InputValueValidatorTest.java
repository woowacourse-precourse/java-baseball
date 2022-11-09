package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.InputValueValidator;

import org.junit.jupiter.api.Test;

public class InputValueValidatorTest {

    @Test
    void caseOnlyNumberInput(){
        String input = "123";
        assertThat(InputValueValidator.isNumberOnly(input)).isTrue();
    }

    @Test
    void caseNotNumberInput(){
        String input = "1a3";
        assertThat(InputValueValidator.isNumberOnly(input)).isFalse();
    }

    @Test
    void caseStringLengthCorrect(){
        String input = "123";
        int length = 3;
        assertThat(InputValueValidator.isLengthCorrect(input,length)).isTrue();
    }

    @Test
    void caseStringLengthNotCorrect(){
        String input = "1234";
        int length = 3;
        assertThat(InputValueValidator.isLengthCorrect(input,length)).isFalse();
    }

    @Test
    void caseNoDuplicatedValue(){
        String input = "abc";
        assertThat(InputValueValidator.isNoDuplicatedValue(input)).isTrue();
    }

    @Test
    void caseDuplicatedValue(){
        String input = "abb";
        assertThat(InputValueValidator.isNoDuplicatedValue(input)).isFalse();
    }

    @Test
    void caseContainValue(){
        String input = "1";
        int[] value = {1,2};
        assertThat(InputValueValidator.isContainValues(input, value)).isTrue();
    }

    @Test
    void caseNoContainValue(){
        String input = "3";
        int[] value = {1,2};
        assertThat(InputValueValidator.isContainValues(input, value)).isFalse();
    }
}
