package baseball.domain;

import baseball.domain.ball.Balls;
import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintService;
import baseball.factory.BallFactory;
import baseball.global.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintServiceTest {

    AppConfig appConfig = new AppConfig();
    HintService hintService = appConfig.hintService();

    @Nested
    @DisplayName("힌트 주기")
    class giveHint {

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 위치와 값이 모두 같으면 3스트라이크")
        void three_strike() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 2, 3));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(3);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 값은 같지만 위치가 서로 다르면 3볼")
        void three_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(3, 1, 2));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(3);
        }

        @Test
        @DisplayName("컴퓨터가 입력한 3자리 숫자와 사용자가 입력한 3숫자가 값과 위치가 모두 다르면 낫싱")
        void nothing() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(4, 5, 6));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("같은거 1개, 위치 다른거 2개 = 2볼1스트라이크")
        void one_strike_two_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 3, 2));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(1);
            assertThat(hint.getBall()).isEqualTo(2);
        }

        @Test
        @DisplayName("같은거 2개, 위치 다른거 0개 = 2스트라이크")
        void two_strike() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(1, 2, 5));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(2);
            assertThat(hint.getBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("같은거 0개, 위치 다른거 2개 = 2볼")
        void two_ball() {
            //given
            final Balls answerBall = BallFactory.balls(List.of(1, 2, 3));
            final Balls playerBall = BallFactory.balls(List.of(2, 1, 6));
            //when
            final Hint hint = hintService.createHint(playerBall, answerBall);
            //then
            assertThat(hint.getStrike()).isEqualTo(0);
            assertThat(hint.getBall()).isEqualTo(2);
        }
    }
}
