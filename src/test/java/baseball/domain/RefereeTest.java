package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void generateBall_매서드로_사용자_입력값에_ball이_몇_개있는지_반환() {
        // given
        Computer computer = new Computer(List.of(3, 4, 5));
        Player player = new Player(List.of(1, 2, 3));
        Referee referee = new Referee(computer, player);

        // when
        Ball ball = referee.generateBall();
        int result = ball.getCount();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void generateStrike_매서드로_사용자_입력값에_strike가_몇_개있는지_반환() {
        // given
        Computer computer = new Computer(List.of(1, 4, 5));
        Player player = new Player(List.of(1, 2, 3));
        Referee referee = new Referee(computer, player);

        // when
        Strike strike = referee.generateStrike();
        int result = strike.getCount();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void judge_매서드로_사용자_입력값에_ball과_strike가_몇_개있는지_반환() {
        // given
        Computer computer = new Computer(List.of(1, 4, 5));
        Player player = new Player(List.of(1, 5, 4));
        Referee referee = new Referee(computer, player);

        // when
        Result result = referee.judge();
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        // then
        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(1);
    }
}