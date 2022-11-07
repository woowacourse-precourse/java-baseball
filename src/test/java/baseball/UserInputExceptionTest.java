package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserInputExceptionTest {

    @Nested
    @DisplayName("입력에 문자가 포함되어 있는지 확인하는 메소드")
    class IsContainLetter {
        @Test
        @DisplayName("모두 숫자일 때")
        void noLetter() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            String input = "131235346546";

            //When
            boolean containLetter = exception.isContainLetter(input);

            //Then
            assertThat(containLetter).isFalse();
        }

        @Test
        @DisplayName("문자를 포함하고 있을 때")
        void hasLetter() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            String input = "1213a134a";

            //When
            boolean containLetter = exception.isContainLetter(input);

            //Then
            assertThat(containLetter).isTrue();
        }
    }

    @Test
    void isInputLength() throws Exception {
        //Given
        UserInputException exception = new UserInputException();
        String input = "1232";

        //When
        int wrightLength = 4;
        int wrongLength = 3;
        boolean wright = exception.isInputLength(input, wrightLength);
        boolean wrong = exception.isInputLength(input, wrongLength);

        //Then
        assertThat(wright).isTrue();
        assertThat(wrong).isFalse();
    }

}