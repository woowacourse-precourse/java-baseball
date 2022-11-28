//package baseball.domain;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//
//class ScoreCalculatorTest {
//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//    @Nested
//    @DisplayName("Ball과 Strike가 둘 다 있는 경우를 테스트한다")
//    class BallAndStrike {
//        @ParameterizedTest
//        @MethodSource("parameterProvider")
//        void calculateBallAndStrikeTest(int number1, int number2, List<Integer> expected) {
//            System.out.println(expected);
//            BaseballNumber baseballNum1 = new BaseballNumber(number1);
//            BaseballNumber baseballNum2 = new BaseballNumber(number2);
//            assertThat(ScoreCalculator
//                    .calculateUserFinalScore(baseballNum1, baseballNum2)
//                    .getScore())
//                    .isEqualTo(expected);
//        }
//
//        private Stream<Arguments> parameterProvider() {
//            return Stream.of(
//                    Arguments.of(123, 136, Arrays.asList(1, 1)),
//                    Arguments.of(123, 132, Arrays.asList(2, 1))
//            );
//        }
//    }
//}
