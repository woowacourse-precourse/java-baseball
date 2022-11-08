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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballGameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballGameResultTest {

    @Test
    void toEnum_메서드는_만약_Enum_범위_내의_스트라이크와_볼을_입력받으면_적절한_BaseballGameResult를_리턴한다() {
        final Strike givenStrike = Strike.valueOf(1);
        final Ball givenBall = Ball.valueOf(0);

        BaseballGameResult baseballGameResult = BaseballGameResult.toEnum(givenStrike, givenBall);
        assertThat(baseballGameResult).isInstanceOf(BaseballGameResult.class);
    }

    @Test
    void toEnum_메서드는_만약_Enum_범위_내_존재하지_않는_스트라이크와_볼을_입력받으면_BaseballGameException을_던진다() {
        final Strike givenStrike = Strike.valueOf(2);
        final Ball givenBall = Ball.valueOf(3);

        assertThatThrownBy(() -> BaseballGameResult.toEnum(givenStrike, givenBall))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void isStrikeOut_메서드는_만약_게임_결과가_3_스트라이크인_경우_참을_리턴한다() {
        BaseballGameResult baseballGameResult = _3_STRIKE;

        assertThat(baseballGameResult.isStrikeOut()).isTrue();
    }

    @Test
    void isStrikeOut_메서드는_만약_게임_결과가_3_스트라이크가_아닌_경우_거짓을_리턴한다() {
        BaseballGameResult baseballGameResult = BaseballGameResult._1_BALL;

        assertThat(baseballGameResult.isStrikeOut()).isFalse();
    }

    @ParameterizedTest
    @MethodSource("gameResultSet")
    void toString_메서드는_게임_결과에_따라_다른_문자열을_리턴한다(BaseballGameResult baseballGameResult, String result) {
        assertThat(baseballGameResult.toString()).isEqualTo(result);
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
