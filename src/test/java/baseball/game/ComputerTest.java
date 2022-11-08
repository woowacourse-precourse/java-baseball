package baseball.game;

import static baseball.constant.SystemValue.BALL_COUNT;
import static baseball.constant.SystemValue.STRIKE_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    private Computer computer;
    private List<Integer> computerBalls;
    private List<Integer> playerBalls;
    private List<Integer> strikeAndBallCounts;

    @BeforeEach
    void initial() {
        computer = new Computer();
        computerBalls = new ArrayList<>(Arrays.asList(4, 7, 3));
        playerBalls = new ArrayList<>(Arrays.asList(7, 4, 3));
        strikeAndBallCounts = new ArrayList<>(Arrays.asList(0, 0));
    }

    @Test
    void 스트라이크의_수를_카운트합니다() {
        computer.calculateStrikeAndBallCounts(computerBalls, playerBalls, strikeAndBallCounts);

        assertThat(strikeAndBallCounts.get(STRIKE_COUNT))
                .isEqualTo(1);
    }

    @Test
    void 볼의_수를_카운트합니다() {
        computer.calculateStrikeAndBallCounts(computerBalls, playerBalls, strikeAndBallCounts);

        assertThat(strikeAndBallCounts.get(BALL_COUNT))
                .isEqualTo(2);
    }
}
