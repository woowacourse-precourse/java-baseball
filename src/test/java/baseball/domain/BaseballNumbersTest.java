package baseball.domain;

import static baseball.domain.BaseballGameResult._1_BALL;
import static baseball.domain.BaseballGameResult._1_STRIKE;
import static baseball.domain.BaseballGameResult._1_STRIKE_1_BALL;
import static baseball.domain.BaseballGameResult._1_STRIKE_2_BALL;
import static baseball.domain.BaseballGameResult._2_BALL;
import static baseball.domain.BaseballGameResult._2_STRIKE;
import static baseball.domain.BaseballGameResult._3_BALL;
import static baseball.domain.BaseballGameResult._3_STRIKE;
import static baseball.domain.BaseballGameResult._NOTHING;
import static baseball.domain.BaseballNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballNumbers 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumbersTest {

    private static BaseballNumbers generateBaseballNumbers(int ballA, int ballB, int ballC) {
        return new BaseballNumbers(List.of(
                valueOf(ballA),
                valueOf(ballB),
                valueOf(ballC)
        ));
    }

    @Nested
    class 생성자는 {

        @Nested
        class 만약_범위를_벗어난_크기의_리스트를_입력_받으면 {
            List<BaseballNumber> givenList = List.of(valueOf(1));

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> new BaseballNumbers(givenList))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_중복된_숫자가_들어간_리스트를_입력_받으면 {

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> generateBaseballNumbers(9, 3, 3))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }

    @Nested
    class play_메서드는 {

        private BaseballNumbers computer = generateBaseballNumbers(9, 3, 1);

        @Nested
        class 사용자의_값이_입력된_경우 {

            @ParameterizedTest(name = "컴퓨터가 [9, 3, 1]일 때 {0}이 입력된 경우 결과는 {1}")
            @MethodSource("baseball.domain.BaseballNumbersTest#baseballGameNumbersAndGameResult")
            void 컴퓨터와의_게임_결과를_리턴한다(BaseballNumbers player, BaseballGameResult expectGameResult) {
                BaseballGameResult gameResult = computer.play(player);
                assertThat(gameResult).isEqualTo(expectGameResult);
            }
        }
    }

    static List<Arguments> baseballGameNumbersAndGameResult() {
        return Arrays.asList(
                Arguments.of(generateBaseballNumbers(9, 3, 1), _3_STRIKE),
                Arguments.of(generateBaseballNumbers(4, 3, 1), _2_STRIKE),
                Arguments.of(generateBaseballNumbers(4, 5, 1), _1_STRIKE),
                Arguments.of(generateBaseballNumbers(9, 1, 3), _1_STRIKE_2_BALL),
                Arguments.of(generateBaseballNumbers(9, 1, 7), _1_STRIKE_1_BALL),
                Arguments.of(generateBaseballNumbers(1, 9, 3), _3_BALL),
                Arguments.of(generateBaseballNumbers(3, 1, 5), _2_BALL),
                Arguments.of(generateBaseballNumbers(3, 6, 5), _1_BALL),
                Arguments.of(generateBaseballNumbers(8, 2, 4), _NOTHING)
        );
    }
}
