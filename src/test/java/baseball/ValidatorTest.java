package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void init() {
        validator = new Validator();
    }

    @DisplayName("검증자는 게임 중 투수가 입력한 값이 길이가 3인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "1234"})
    void validateGameNumberLength(String pitchValue) {
        assertThatThrownBy(() -> validator.validatePitchValue(pitchValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수를 입력해주세요.");
    }

    @DisplayName("검증자는 게임 중 투수가 입력한 수가 1부터 9까지 이루어진 수인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"100", "000", "980"})
    void validateIsAllDigitExceptForZero(String pitchValue) {
        assertThatThrownBy(() -> validator.validatePitchValue(pitchValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0을 제외한 숫자만 입력해주세요.");
    }

    @DisplayName("검증자는 게임 중 투수가 입력한 수가 서로 다른 수인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"111", "223", "288"})
    void validateIsComposedOfSeparateNumbers(String pitchValue) {
        assertThatThrownBy(() -> validator.validatePitchValue(pitchValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수를 입력해주세요.");
    }

    @DisplayName("검증자는 투수가 정답을 맞춘 뒤 게임 진행을 위해 입력한 값이 길이가 1인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "12", "123"})
    void validateGameProcessLength(String gameProcessValue) {
        assertThatThrownBy(() -> validator.validateGameProcessValue(gameProcessValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자리 수를 입력해주세요.");
    }

    @DisplayName("검증자는 투수가 정답을 맞춘 뒤 게임 진행을 위해 입력한 값이 수인지 검증한다.")
    void validateIsDigit(String gameProcessValue) {
        assertThatThrownBy(() -> validator.validateGameProcessValue(gameProcessValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }

    @DisplayName("검증자는 투수가 정답을 맞춘 뒤 게임 진행을 위해 입력한 값이 1 또는 2인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "6", "9"})
    void validateIs1Or2(String gameProcessValue) {
        assertThatThrownBy(() -> validator.validateGameProcessValue(gameProcessValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수만 입력해주세요.");
    }
}