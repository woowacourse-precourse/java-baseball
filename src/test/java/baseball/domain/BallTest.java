package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Ball 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BallTest {
    private final int BALL_LOWER_BOUND = 0;
    private final int BALL_UPPER_BOUND = 3;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void valueOf_메서드는_만약_0과_3사이의_값을_입력받으면_Ball_객체를_리턴한다(int count) {
        assertThat(Ball.valueOf(count)).isInstanceOf(Ball.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_높은_값을_입력받으면_BaseballGameException을_던진다() {
        Integer givenNumber = BALL_UPPER_BOUND + 1;
        assertThatThrownBy(() -> Ball.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_낮은_값을_입력받으면_BaseballGameException을_던진다() {
        Integer givenNumber = BALL_LOWER_BOUND - 1;
        assertThatThrownBy(() -> Ball.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void toString_메서드는_만약_볼_카운트가_0인_경우_빈_문자열을_리턴한다() {
        Ball ball = Ball.valueOf(0);
        assertThat(ball.toString()).isEqualTo("");
    }

    @ParameterizedTest(name = "볼 카운트가 {0}인 경우 {1}을 리턴한다")
    @CsvSource(value = {"1, 1볼", "2, 2볼", "3, 3볼"})
    void toString_메서드는_만약_볼_카운트가_0이_아닌_경우_X볼_문자열을_리턴한다(int count, String result) {
        Ball ball = Ball.valueOf(count);
        assertThat(ball.toString()).isEqualTo(result);
    }
}
