package baseball.domain;

import static baseball.domain.Number.MAX_NUMBER;
import static baseball.domain.Number.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    private static final int EXPECTED_MIN_NUMBER = 1;
    private static final int EXPECTED_MAX_NUMBER = 9;

    static IntStream numberRange() {
        return IntStream.rangeClosed(EXPECTED_MIN_NUMBER, EXPECTED_MAX_NUMBER);
    }

    @Nested
    class Create {
        @Test
        @DisplayName("초기 세팅값이 정상적으로 적용되어 있는지 확인한다.")
        void init() {
            assertThat(MIN_NUMBER).as("공의 숫자 최소값이 1인지 확인")
                    .isEqualTo(EXPECTED_MIN_NUMBER);
            assertThat(MAX_NUMBER).as("공의 숫자 최대값이 9인지 확인")
                    .isEqualTo(EXPECTED_MAX_NUMBER);
        }

        @ParameterizedTest(name = "공 값은 1~9 사이에서 정상 생성된다. (공 숫자 값 : {0})")
        @MethodSource("baseball.domain.NumberTest#numberRange")
        void create(int value) {
            Number number = Number.from(value);
            assertThat(number.value()).as("공 위치 값이 동일하게 대입 되었는지 확인.")
                    .isEqualTo(value);
        }

        @Test
        @DisplayName("랜덤 공 숫자값이 1~9 사이 정상 생성되는지 확인한다.")
        void createRandomBallNumberValue() {
            int randomNumber = Number.getRandomNumber();
            assertThat(randomNumber).as("1~9 사이 랜덤 값 생성여부 확인")
                    .isBetween(EXPECTED_MIN_NUMBER, EXPECTED_MAX_NUMBER);
        }
    }

    @Nested
    class Validate {
        @ParameterizedTest(name = "공 숫자 값이 최소/최대값을 벗어나면 IllegalArgumentException이 발생한다. (공 위치 : {0})")
        @ValueSource(ints = {EXPECTED_MIN_NUMBER - 1, EXPECTED_MAX_NUMBER + 1})
        void exception(int outOfRangeNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(
                            () -> Number.from(outOfRangeNumber)
                    )
                    .withMessageMatching("Number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }
}
