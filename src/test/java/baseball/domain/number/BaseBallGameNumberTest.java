package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BaseBallGameNumber 는 ")
class BaseBallGameNumberTest {

    @Test
    @DisplayName("문자열을 통해 생성될 수 있다.")
    void constructedByString() {
        // given
        String input = "1";

        // when
        BaseBallGameNumber ballGameNumber = new BaseBallGameNumber(input);

        // then
        assertThat(ballGameNumber.value()).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("정수를 통해 생성될 수 있다.")
    void constructedByInteger() {
        // given
        int input = 1;

        // when
        BaseBallGameNumber ballGameNumber = new BaseBallGameNumber(input);

        // then
        assertThat(ballGameNumber.value()).isEqualTo(input);
    }

    @ParameterizedTest(name = "1 ~ 9 사이를 벗어난 수({arguments})를 입력받은 경우 IllegalArgumentException을 발생시킨다.")
    @ValueSource(strings = {"10", "0", "-1"})
    void throwIllegalArgumentExceptionWhenConstructedByInvalidInput(final String input) {

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumber(input));
    }

    @Test
    @DisplayName("같은 값을 가진 경우 equals실행 시 true를 반환한다.")
    void equalsIsTrueWhenHasSameValue() {
        // given
        int value = 5;
        BaseBallGameNumber ballGameNumber = new BaseBallGameNumber(value);
        BaseBallGameNumber ballGameNumber2 = new BaseBallGameNumber(value);

        // when
        boolean result = ballGameNumber.equals(ballGameNumber2);

        // then
        assertThat(result).isTrue();
    }
}