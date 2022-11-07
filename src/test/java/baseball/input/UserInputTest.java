package baseball.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;


class UserInputTest {

    UserInput userInput = new UserInput();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


    @Nested
    @DisplayName("유저넘버 리스트")
    class UserNumberList{

        @Test
        @DisplayName("숫자 3개 보다 더 많이 입력")
        void 숫자_3개보다_더_많이_입력() {
            String input = "1234";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자 3개 보다 더 적게 입력")
        void 숫자_3개보다_더_적게_입력() {
            String input = "12";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복값 넣음")
        void 중복값_넣음() {
            String input = "112";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자 아닌 값 넣음")
        void 숫자_아닌_값_넣음() {
            String input = "12ㄱ";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
    @Nested
    @DisplayName("재시작 옵션")
    class UserRestartOption{
        @Test
        @DisplayName("1보다 더 큰 사이즈 넣음")
        void 더_큰_사이즈() {
            String input = "12";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자말고 다른 형태 넣음")
        void 숫자_말고_다른형태의_인풋() {
            String input = "ㄱ";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자말고 다른 형태 넣음 영어")
        void 숫자_말고_다른형태의_인풋_영어() {
            String input = "A";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("1이나 2가 아닌 다른 옵션 넣음")
        void 다른_옵션() {
            String input = "0";
            setSetIn(input);
            Assertions.assertThatThrownBy(() -> userInput.getNumberList())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}