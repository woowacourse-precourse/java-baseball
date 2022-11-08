package baseball.game;

import static baseball.constant.HintType.BALL;
import static baseball.constant.HintType.NOTHING;
import static baseball.constant.HintType.STRIKE;
import static baseball.constant.SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER;
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
    private List<Integer> strikeAndBallResults;

    @BeforeEach
    void initialize() {
        computer = new Computer();
        computerBalls = new ArrayList<>(Arrays.asList(4, 7, 3));
        playerBalls = new ArrayList<>(Arrays.asList(7, 4, 3));
        strikeAndBallResults = new ArrayList<>(Arrays.asList(0, 0));
    }

    @Test
    void 스트라이크의_수를_카운트합니다() {
        computer.countStrikeAndBallResults(computerBalls, playerBalls, strikeAndBallResults);

        assertThat(strikeAndBallResults.get(STRIKE_COUNT))
                .isEqualTo(1);
    }

    @Test
    void 볼의_수를_카운트합니다() {
        computer.countStrikeAndBallResults(computerBalls, playerBalls, strikeAndBallResults);

        assertThat(strikeAndBallResults.get(BALL_COUNT))
                .isEqualTo(2);
    }

    @Test
    void 스트라이크의_수를_반환합니다() {
        int strikeCount = 1;
        int ballCount = 0;
        String hint = computer.getHint(strikeCount, ballCount);

        assertThat(hint)
                .isEqualTo(strikeCount + STRIKE.getHint());
    }

    @Test
    void 볼의_수를_반환합니다() {
        int strikeCount = 0;
        int ballCount = 2;
        String hint = computer.getHint(strikeCount, ballCount);

        assertThat(hint)
                .isEqualTo(ballCount + BALL.getHint());
    }

    @Test
    void 스트라이크와_볼의_수를_반환합니다() {
        int strikeCount = 1;
        int ballCount = 2;
        String hint = computer.getHint(strikeCount, ballCount);

        assertThat(hint)
                .isEqualTo(ballCount + BALL.getHint() + " " + strikeCount + STRIKE.getHint());
    }

    @Test
    void 스트라이크를_3개를_반환합니다() {
        int strikeCount = 3;
        int ballCount = 0;
        String hint = computer.getHint(strikeCount, ballCount);

        assertThat(hint)
                .isEqualTo(THREE_NUMBERS_RIGHT_GAME_OVER);
    }

    @Test
    void 낫싱을_반환합니다() {
        int strikeCount = 0;
        int ballCount = 0;
        String hint = computer.getHint(strikeCount, ballCount);

        assertThat(hint)
                .isEqualTo(NOTHING.getHint());
    }
}
