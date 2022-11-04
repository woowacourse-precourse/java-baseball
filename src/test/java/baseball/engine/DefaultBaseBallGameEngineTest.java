package baseball.engine;


import baseball.model.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultBaseBallGameEngineTest {
    private BaseBallGameEngine gameEngine;

    @BeforeEach
    void setUp() {
        gameEngine = new DefaultBaseBallGameEngine();
    }

    @Nested
    class DescribeParseToNumbers {
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"\n", "\t"})
        @DisplayName("사용자 입력 숫자가 null이거나 비었을경우, 공백문자일 경우 테스트")
        void userInputNullAndEmpty(String userInput) {
            Assertions.assertThatThrownBy(() -> gameEngine.parseToNumbers(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"asd", "12a", "1234", "!@#"})
        @DisplayName("사용자 입력에 문자가 포함되어 있거나 길이를 초과했을경우")
        void isNotValidUserInput(String notValidInput) {
            Assertions.assertThatThrownBy(() -> gameEngine.parseToNumbers(notValidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("사용자 입력이 유효한 숫자일경우")
        void isValidUserInput() {
            String userInput = "123";
            Numbers actualNumbers = gameEngine.parseToNumbers(userInput);

            //해당 객체의 리스트 내에 값이 있는지 확인하기 위해 containAnswer메서드를 이용했다.
            Assertions.assertThat(actualNumbers.containAnswer(1)).isTrue();
            Assertions.assertThat(actualNumbers.containAnswer(2)).isTrue();
            Assertions.assertThat(actualNumbers.containAnswer(3)).isTrue();
        }
    }
}