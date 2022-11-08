package baseball.components;

import baseball.controller.BaseballGameController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameControllerTest extends NsTest {

    @Test
    @DisplayName("예외_테스트 - 새 게임 시작 선택시 1,2외 입력")
    void nextGameInputExceptionTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("142", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(BaseballGameController.NEXT_GAME_INPUT_ERROR_MSG);
                },
                1, 3, 5
        );
    }

    @ParameterizedTest(name = "사용자 입력 예외 테스트 [{index}] - 사용자 입력값 : {0}")
    @ValueSource(strings = {"13", "1234", "abc", "709", "122", "332", "565", "777"})
    void playerNumberInputValidationTest(final String playerInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(playerInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BaseballGameController.PLAYER_NUMBER_INPUT_ERROR_MSG)
        );
    }


    @Override
    protected void runMain() {
        BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.startGame();
    }
}