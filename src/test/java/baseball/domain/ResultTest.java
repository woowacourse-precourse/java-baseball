package baseball.domain;

import static baseball.Constants.EXIT;
import static baseball.Constants.START;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void isRoundFinish_매서드로_라운드가_종료됐으면_EXIT을_반환() {
        // given
        Computer computer = new Computer(List.of(1, 4, 5));
        Player player = new Player(List.of(1, 4, 5));
        Referee referee = new Referee(computer, player);
        Result result = referee.judge();

        // when
        int roundFinish = result.isRoundFinish();

        // then
        assertThat(roundFinish).isEqualTo(EXIT);
    }

    @Test
    void isRoundFinish_매서드로_라운드가_종료되지_않으면_START를_반환() {
        // given
        Computer computer = new Computer(List.of(1, 4, 5));
        Player player = new Player(List.of(1, 5, 4));
        Referee referee = new Referee(computer, player);
        Result result = referee.judge();

        // when
        int roundFinish = result.isRoundFinish();

        // then
        assertThat(roundFinish).isEqualTo(START);
    }
}