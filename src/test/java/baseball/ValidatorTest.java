package baseball;

import baseball.model.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "s", "12", "-"})
    @DisplayName("잘못된 입력값(재시작/종료 여부) 예외 테스트")
    void wrongGameCommand(String input) {
        assertThatThrownBy(() -> Validator.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
