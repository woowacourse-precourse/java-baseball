package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
    private static BaseBallGame baseBallGame;

    @BeforeEach
    private void initNumber() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    void 게임_종료_답변_입력_case1() {
        assertThrows( IllegalArgumentException.class,
                () -> baseBallGame.questionAboutGameExitingForTest("3")
        );
    }

    @Test
    void 게임_종료_답변_입력_case2() {
        assertThrows( IllegalArgumentException.class,
                () -> baseBallGame.questionAboutGameExitingForTest("a")
        );
    }



}
