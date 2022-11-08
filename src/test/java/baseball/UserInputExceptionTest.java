package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Nested
    @DisplayName("종복된 숫자가 들어왔는지 판별하는 메소드")
    class HasSameNumberInList {
        @Test
        @DisplayName("종복이 없을 때")
        void hasNoDuplicate() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            List<Integer> input = List.of(1, 2, 3);

            //When
            boolean result = exception.hasSameNumberInList(input);

            //Then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("중복이 있을 때")
        void hasDuplication() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            List<Integer> input = List.of(1, 2, 1);

            //When
            boolean result = exception.hasSameNumberInList(input);

            //Then
            assertThat(result).isTrue();
        }
    }

    @Nested
    @DisplayName("유저의 입력이 허용된 인력인지 판발")
    class IsIllegalChoice {
        @Test
        @DisplayName("허용되지 않는 입력일 때")
        void illegalChoice() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            String choice = "3";

            //When
            boolean choiceResult = exception.isIllegalChoice(choice);

            //Then
            assertThat(choiceResult).isTrue();
        }

        @Test
        @DisplayName("허용된 입력일 때")
        void legalChoice() throws Exception {
            //Given
            UserInputException exception = new UserInputException();
            String choice = "2";

            //When
            boolean choiceResult = exception.isIllegalChoice(choice);

            //Then
            assertThat(choiceResult).isFalse();
        }
    }

}