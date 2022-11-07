package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    private InputStream inputStream;

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("3자리가 아닌것을 확인하는 기능 - 예외발생")
    @Test
    void 세자리수가_아닌것을_확인하는기능_예외() {
        String input = "abcdef";

        assertThatThrownBy(() -> Validate.inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른숫자인지 확인하는 기능 - 예외발생")
    @Test
    void 서로_다른_숫자인지_확인() {
        String input = "121";

        assertThatThrownBy(() -> Validate.inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이 포함되지 않았는지 확인하는 기능 - 예외")
    @Test
    void 숫자_0이_포함되지_않았는지_확인_예외() {
        String input = "120";

        assertThatThrownBy(() -> Validate.inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void 게임종료시_1입력() {
        String userInput = "1";

        assertThat(Validate.isAcceptAbleEndGame(userInput)).isTrue();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void 게임종료시_2입력() {
        String userInput = "2";

        assertThat(Validate.isAcceptAbleEndGame(userInput)).isTrue();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void 게임종료시_예외입력() {
        String userInput = "3";

        assertThatThrownBy(() -> Validate.inputValidate(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 검증 기능에 부합하지 않은 입력시 예외 발생")
    @Test
    void 사용자_입력_1도아니고_2도아니면_예외를_확인하는_테스트() {
        String theInput = "3";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> Validate.isAcceptAbleEndGame(theInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}