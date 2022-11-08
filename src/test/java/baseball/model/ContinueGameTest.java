package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContinueGameTest {
    private static final String CONTINUE_ERROR_MESSAGE = "한 자리 숫자 1, 2 이외의 값이 들어갔습니다.";
    private final ContinueGame continueGame = ContinueGame.getInstance();

    @Test
    void 게임을_계속하는_경우의_테스트() {
        String inputToSelectGame = "1";

        boolean isContinue = continueGame.selectContinueGame(inputToSelectGame);

        Assertions.assertThat(isContinue).isTrue();
    }

    @Test
    void 게임을_계속하지않는_경우의_테스트() {
        String inputToSelectGame = "2";

        boolean isContinue = continueGame.selectContinueGame(inputToSelectGame);

        Assertions.assertThat(isContinue).isFalse();
    }

    @Test
    void 사용자가_지정한_숫자_값_이외가_올_때_예외를_던지는_테스트() {
        String inputToSelectGame = "3";

        assertThatThrownBy(() -> continueGame.selectContinueGame(inputToSelectGame))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTINUE_ERROR_MESSAGE);
    }

    @Test
    void 사용자가_지정한_값이외를_작성할때_예외를_던지는_테스트() {
        String inputToSelectGame = "error";

        assertThatThrownBy(() -> continueGame.selectContinueGame(inputToSelectGame))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTINUE_ERROR_MESSAGE);
    }

    @Test
    void 사용자가_값을_적지_않을_경우_예외를_던지는_테스트() {
        String inputToSelectGame = "error";

        assertThatThrownBy(() -> continueGame.selectContinueGame(inputToSelectGame))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTINUE_ERROR_MESSAGE);
    }
}