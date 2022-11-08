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

    @DisplayName("게임 종료 뒤 재시작 또는 종료 진행과 관련한 입력 오류 - [1] 1자리 값이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12", "123"})
    void invalidInputForGameProcess(String input) {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("246", "135", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1자리 수를 입력해주세요."),
                1, 3, 5
        );
    }

    @DisplayName("게임 종료 뒤 재시작 또는 종료 진행과 관련한 입력 오류 - [2] 수가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "*"})
    void invalidInputForGameProcessNonDigit(String input) {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("246", "135", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자만 입력해주세요."),
                1, 3, 5
        );
    }

    @DisplayName("게임 종료 뒤 재시작 또는 종료 진행과 관련한 입력 오류 - [3] 1 또는 2가 아닌 경우")
    @ParameterizedTest()
    @ValueSource(strings = {"0", "3"})
    void invalidInputForGameProcessNon1Or2(String input) {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("246", "135", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수만 입력해주세요."),
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}