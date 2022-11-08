package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallPositionTest {

    private static final int EXPECTED_MAX_POSITION = 3;
    private static final int EXPECTED_MIN_POSITION = 1;

    static IntStream ballPositionRange() {
        return IntStream.range(EXPECTED_MIN_POSITION, EXPECTED_MAX_POSITION + 1);
    }

    @Nested
    class 정상_생성_테스트 {

        @Test
        @DisplayName("초기 세팅값이 정상적으로 적용되어 있는지 확인한다.")
        void 초기값() {
            //then
            assertThat(BallPosition.MIN_POSITION).as("위치 최소값이 1인지 확인")
                    .isEqualTo(EXPECTED_MIN_POSITION);

            assertThat(BallPosition.MAX_POSITION).as("위치 최대값이 3인지 확인")
                    .isEqualTo(EXPECTED_MAX_POSITION);

        }

        @ParameterizedTest(name = "공 위치는 1 ~ 3 사이에서 정상 생성된다. (공 위치 : {0})")
        @MethodSource("baseball.model.BallPositionTest#ballPositionRange")
        void 생성1(int position) {
            // given
            BallPosition ballPosition = BallPosition.from(position);

            //then
            assertThat(ballPosition.value()).as("공 위치 값이 동일하게 대입 되었는지 확인.")
                    .isEqualTo(position);
        }
    }

    @Nested
    class 유효성_검증_테스트 {

        @ParameterizedTest(name = "공 위치가 최소/최대값을 벗어나면 IllegalArgumentException이 발생한다. (공 위치 : {0})")
        @ValueSource(ints = {EXPECTED_MIN_POSITION - 1, EXPECTED_MAX_POSITION + 1})
        void 예외1(int outOfRangePositionValue) {
            assertThatIllegalArgumentException()
                    .isThrownBy(
                            // when
                            () -> BallPosition.from(outOfRangePositionValue)
                    )
                    .withMessageMatching("공 위치는 1~3 사이 값만 생성 가능합니다."); //then
        }
    }
}