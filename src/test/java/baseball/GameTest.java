package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {
    @DisplayName("게임 종료 뒤 재시작 없이 종료")
    @Test
    void endGameRightAfterCorrect() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 중 투수의 입력 오류 - [1] 3자리 수가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "12345"})
    void invalidInputInGame(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("게임 중 투수의 입력 오류 - [2] 문자 또는 0이 포함된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"012", "a23"})
    void invalidInputInGameIncludingCharOrZero(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("게임 중 투수의 입력 오류 - [3] 서로 같은 수가 포함된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"112", "223"})
    void invalidInputInGameHasDuplicateNumber(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}