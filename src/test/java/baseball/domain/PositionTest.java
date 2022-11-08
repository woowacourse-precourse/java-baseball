package baseball.domain;

import static baseball.domain.Position.MAX_POSITION;
import static baseball.domain.Position.MIN_POSITION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {
    private static final int EXPECTED_MAX_POSITION = 3;
    private static final int EXPECTED_MIN_POSITION = 1;

    static IntStream positionRange() {
        return IntStream.rangeClosed(EXPECTED_MIN_POSITION, EXPECTED_MAX_POSITION);
    }

    @Nested
    class Create {
        @Test
        @DisplayName("초기 세팅값이 정상적으로 적용되어 있는지 확인한다.")
        void init() {
            assertThat(MIN_POSITION).as("위치 최소값이 1인지 확인")
                    .isEqualTo(EXPECTED_MIN_POSITION);
            assertThat(MAX_POSITION).as("위치 최대값이 3인지 확인")
                    .isEqualTo(EXPECTED_MAX_POSITION);
        }

        @ParameterizedTest(name = "공 위치는 1 ~ 3 사이에서 정상 생성된다. (공 위치 : {0})")
        @MethodSource("baseball.domain.PositionTest#positionRange")
        void create(int value) {
            Position position = Position.from(value);
            assertThat(position.value()).as("공 위치 값이 동일하게 대입 되었는지 확인.")
                    .isEqualTo(value);
        }
    }

    @Nested
    class Validation {
        @ParameterizedTest(name = "공 위치가 최소/최대값을 벗어나면 IllegalArgumentException이 발생한다. (공 위치 : {0})")
        @ValueSource(ints = {EXPECTED_MIN_POSITION - 1, EXPECTED_MAX_POSITION + 1})
        void validate(int outOfRangePositionValue) {
            assertThatIllegalArgumentException()
                    .isThrownBy(
                            () -> Position.from(outOfRangePositionValue)
                    )
                    .withMessageMatching("Position must be between " + MIN_POSITION + " and " + MAX_POSITION);
        }
    }
}
