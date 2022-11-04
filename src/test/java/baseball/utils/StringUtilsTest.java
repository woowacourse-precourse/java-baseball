package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @DisplayName("예외 처리 : null 또는 empty 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void blank_exception(String numbers) {
        assertThat(StringUtils.isBlank(numbers)).isTrue();
    }
}