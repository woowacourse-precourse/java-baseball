package baseball.service;

import static org.assertj.core.api.Assertions.*;

import baseball.sevice.NumberBaseballService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballServiceTest {

    private final NumberBaseballService numberBaseballService = new NumberBaseballService();

    @DisplayName("사용자 입력이 1 ~ 9 숫자가 아니라면 IllegalArgumentException 예외 발생 테스트")
    @Test
    void checkNumberFail() {
        // given
        String outOfRangeInput = "012";
        String nonNumericInput = "abc";

        // when
        // then
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(outOfRangeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9사이의 숫자만 입력해야 합니다.");
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9사이의 숫자만 입력해야 합니다.");
    }

    @DisplayName("사용자 입력이 1 ~ 9 사이의 숫자라면 정상 동작 태스트")
    @Test
    void checkNumberSuccess() {
        // given
        String normalInput = "123";

        // when
        numberBaseballService.inputUserAnswer(normalInput);
    }

}
