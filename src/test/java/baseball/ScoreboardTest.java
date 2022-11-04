package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreboardTest {
    @Test
    void 리스트형으로_반환() {
        Scoreboard scoreboard = new Scoreboard(2, 1);
        List<Integer> list = scoreboard.toList();

        assertThat(list).containsExactly(2, 1);
    }

    @Test
    void 볼_점수_가져오기() {
        Scoreboard scoreboard = new Scoreboard(2, 0);
        int ballPoint = scoreboard.getBallPoint();

        assertThat(ballPoint).isEqualTo(2);
    }

    @Test
    void 스트라이크_점수_가져오기() {
        Scoreboard scoreboard = new Scoreboard(0, 3);
        int strikePoint = scoreboard.getStrikePoint();

        assertThat(strikePoint).isEqualTo(3);
    }

    @Test
    void 볼_점수_더하기() {
        Scoreboard scoreboard = new Scoreboard(1, 0);
        scoreboard.addBallPoint();

        int ballPoint = scoreboard.getBallPoint();

        assertThat(ballPoint).isEqualTo(2);
    }

    @Test
    void 스트라이크_점수_더하기() {
        Scoreboard scoreboard = new Scoreboard(0, 1);
        scoreboard.addStrikePoint();

        int strikePoint = scoreboard.getStrikePoint();

        assertThat(strikePoint).isEqualTo(2);
    }
}
