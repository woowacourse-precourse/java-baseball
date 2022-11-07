package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void countBallInPlayerInput_매서드로_사용자_입력값에_ball이_몇_개있는지_반환() {
        // given
        Computer computer = new Computer(List.of(3, 4, 5));
        Player player = new Player(List.of(1, 2, 3));
        Referee referee = new Referee(computer, player);

        // when
        Ball ball = referee.countBallInPlayerInput();
        int result = ball.getCount();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void countStrikeInPlayerInput_매서드로_사용자_입력값에_strike가_몇_개있는지_반환() {
        // given
        Computer computer = new Computer(List.of(1, 4, 5));
        Player player = new Player(List.of(1, 2, 3));
        Referee referee = new Referee(computer, player);

        // when
        Strike strike = referee.countStrikeInPlayerInput();
        int result = strike.getCount();

        // then
        assertThat(result).isEqualTo(1);
    }
}