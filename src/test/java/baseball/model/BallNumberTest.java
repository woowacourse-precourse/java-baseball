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

class BallNumberTest {

    private static final int EXPECTED_MIN_BALL_NUMBER = 1;
    private static final int EXPECTED_MAX_BALL_NUMBER = 9;

    static IntStream ballNumberRange() {
        return IntStream.range(EXPECTED_MIN_BALL_NUMBER, EXPECTED_MAX_BALL_NUMBER + 1);
    }

    @Nested
    class 정상_생성_테스트 {

        @Test
        @DisplayName("초기 세팅값이 정상적으로 적용되어 있는지 확인한다.")
        void 초기값() {
            //then
            assertThat(BallNumber.MIN_NUMBER).as("공의 숫자 최소값이 1인지 확인")
                    .isEqualTo(EXPECTED_MIN_BALL_NUMBER);

            assertThat(BallNumber.MAX_NUMBER).as("공의 숫자 최대값이 9인지 확인")
                    .isEqualTo(EXPECTED_MAX_BALL_NUMBER);

        }

        @ParameterizedTest(name = "공 값은 1~9 사이에서 정상 생성된다. (공 숫자 값 : {0})")
        @MethodSource("baseball.model.BallNumberTest#ballNumberRange")
        void 생성1(int ballNumberValue) {
            // given
            BallNumber ballNumber = BallNumber.from(ballNumberValue);

            //then
            assertThat(ballNumber.value()).as("공 위치 값이 동일하게 대입 되었는지 확인.")
                    .isEqualTo(ballNumberValue);
        }

        @Test
        @DisplayName("랜덤 공 숫자값이 1~9 사이 정상 생성되는지 확인한다.")
        void createRandomBallNumberValue() {
            // when
            int randomBallNumberValue = BallNumber.createRandomBallNumberValue();

            //then
            assertThat(randomBallNumberValue).as("1~9 사이 랜덤 값 생성여부 확인")
                    .isBetween(EXPECTED_MIN_BALL_NUMBER, EXPECTED_MAX_BALL_NUMBER);
        }
    }

    @Nested
    class 유효성_검증_테스트 {

        @ParameterizedTest(name = "공 숫자 값이 최소/최대값을 벗어나면 IllegalArgumentException이 발생한다. (공 위치 : {0})")
        @ValueSource(ints = {EXPECTED_MIN_BALL_NUMBER - 1, EXPECTED_MAX_BALL_NUMBER + 1})
        void 예외1(int outOfRangeBallNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(
                            // when
                            () -> BallNumber.from(outOfRangeBallNumber)
                    )
                    .withMessageMatching("공 위치는 1~9 사이 값만 생성 가능합니다."); //then
        }
    }
}