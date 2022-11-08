package baseball.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    @DisplayName("입력 데이터의 유효성 검사 테스트 -> 유효성에 맞지 않는 데이터가 들어오면 IllegalArgumentException 예외 발생")
    void isDigitAndIsLength() {
        // given
        String data = "ab";

        // when && then
        assertThatThrownBy(() -> new Validation(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number is Not Valid Exception!!");
    }

    @Test
    @DisplayName("중복된 원소가 들어올 때 예외 발생 IllegalArgumentException")
    void duplicatedValid() {
        // given
        String data = "122";

        // when && then
        assertThatThrownBy(() -> new Validation(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number is Not Valid Exception!!");
    }
}