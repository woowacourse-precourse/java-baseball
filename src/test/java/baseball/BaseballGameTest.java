package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BaseballGameTest {

    @Test
    void ball_한_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(1, 7, 4);

        BaseballGame baseballGame = new BaseballGame();

        int ballCount = baseballGame.getBallCount(userNumbers, computerNumbers);

        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void ball_두_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(1, 5, 4);

        BaseballGame baseballGame = new BaseballGame();

        int ballCount = baseballGame.getBallCount(userNumbers, computerNumbers);

        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void ball_세_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(1, 5, 3);

        BaseballGame baseballGame = new BaseballGame();

        int ballCount = baseballGame.getBallCount(userNumbers, computerNumbers);

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void strike_한_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(6, 7, 5);

        BaseballGame baseballGame = new BaseballGame();

        int strikeCount = baseballGame.getStrikeCount(userNumbers, computerNumbers);

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void strike_두_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(6, 1, 5);

        BaseballGame baseballGame = new BaseballGame();

        int strikeCount = baseballGame.getStrikeCount(userNumbers, computerNumbers);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void strike_세_개일_경우() {
        List<Integer> userNumbers = Arrays.asList(3, 1, 5);
        List<Integer> computerNumbers = Arrays.asList(3, 1, 5);

        BaseballGame baseballGame = new BaseballGame();

        int strikeCount = baseballGame.getStrikeCount(userNumbers, computerNumbers);

        assertThat(strikeCount).isEqualTo(3);
    }
}
