package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("1 ~ 9 사이의 정수를 입력받지 못한 경우 IllegalArgumentException을 발생시킨다.")
    void throwIllegalArgumentExceptionWhenConstructedByInvalidInput() {
        // given
        String largeStringInput = "10";
        String smallStringInput = "0";
        int largeIntInput = 10;
        int smallIntInput = 0;


        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumber(largeStringInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumber(smallStringInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumber(largeIntInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumber(smallIntInput));
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