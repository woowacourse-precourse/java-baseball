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

@DisplayName("BaseballGameResult Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameResultTest {

    @Nested
    class toEnum_메서드는 {

        @Nested
        class 만약_Enum_범위_내의_스트라이크와_볼을_입력받으면 {
            private final Strike givenStrike = Strike.valueOf(1);
            private final Ball givenBall = Ball.valueOf(0);

            @Test
            void 적절한_BaseballGameResult를_리턴한다() {
                BaseballGameResult baseballGameResult = BaseballGameResult.toEnum(givenStrike, givenBall);
                assertThat(baseballGameResult).isInstanceOf(BaseballGameResult.class);
            }
        }

        @Nested
        class 만약_Enum_범위_내_존재하지_않는_스트라이크와_볼을_입력받으면 {
            private final Strike givenStrike = Strike.valueOf(2);
            private final Ball givenBall = Ball.valueOf(3);

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> BaseballGameResult.toEnum(givenStrike, givenBall))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }

    @Nested
    class isStrikeOut_메서드는 {

        @Nested
        class 만약_게임_결과가_3_스트라이크인_경우 {
            BaseballGameResult baseballGameResult = _3_STRIKE;

            @Test
            void 참을_리턴한다() {
                assertThat(baseballGameResult.isStrikeOut()).isTrue();
            }
        }

        @Nested
        class 만약_게임_결과가_3_스트라이크가_아닌_경우 {
            BaseballGameResult baseballGameResult = BaseballGameResult._1_BALL;

            @Test
            void 거짓을_리턴한다() {
                assertThat(baseballGameResult.isStrikeOut()).isFalse();
            }
        }
    }

    @Nested
    class toString_메서드는 {

        @Nested
        class 게임_결과에_따라 {

            @ParameterizedTest
            @MethodSource("baseball.domain.BaseballGameResultTest#gameResultSet")
            void 다른_문자열을_리턴한다(BaseballGameResult baseballGameResult, String result) {
                assertThat(baseballGameResult.toString()).isEqualTo(result);
            }
        }
    }

    static List<Arguments> gameResultSet() {
        return Arrays.asList(
                Arguments.of(_3_STRIKE, "3스트라이크"),
                Arguments.of(_2_STRIKE, "2스트라이크"),
                Arguments.of(_1_STRIKE, "1스트라이크"),
                Arguments.of(_1_STRIKE_2_BALL, "2볼 1스트라이크"),
                Arguments.of(_1_STRIKE_1_BALL, "1볼 1스트라이크"),
                Arguments.of(_3_BALL, "3볼"),
                Arguments.of(_2_BALL, "2볼"),
                Arguments.of(_1_BALL, "1볼"),
                Arguments.of(_NOTHING, "낫싱")
        );
    }
}
