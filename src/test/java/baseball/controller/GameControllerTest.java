package baseball.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("GameNumbers 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameControllerTest {

    @Nested
    class 입력_검증 {
        @ParameterizedTest(name = "한 자리 숫자 입력 실패 => {0}")
        @ValueSource(strings = {"a", "ㄱ", "가", "0", "11"})
        void 한_자리_숫자_입력_실패(String input) {
            assertThatThrownBy(() -> GameController.validateInput("^[1-2]{1}$", input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "한 자리 숫자 입력 성공 => {0}")
        @ValueSource(strings = {"1", "2"})
        void 한_자리_숫자_입력_성공(String input) {
            assertDoesNotThrow(() -> GameController.validateInput("^[1-2]{1}$", input));
        }

        @ParameterizedTest(name = "세 자리 수 입력 실패 => {0}")
        @ValueSource(strings = {"a", "aaa", "ㄱㄱㄱ", "가가가", "1", "22", "000"})
        void 세_자리_숫자_입력_실패(String input) {
            assertThatThrownBy(() -> GameController.validateInput("^[1-9]{3}$", input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "세 자리 수 입력 성공 => {0}")
        @ValueSource(strings = {"111", "234"})
        void 세_자리_숫자_입력_성공(String input) {
            assertDoesNotThrow(() -> GameController.validateInput("^[1-9]{3}$", input));
        }
    }
}