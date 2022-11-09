package baseball.vo;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Scoreboard 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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

    @Test
    void 모든_점수_더하기() {
        Scoreboard scoreboard1 = new Scoreboard(1, 0);
        Scoreboard scoreboard2 = new Scoreboard(1, 1);

        scoreboard1.addAllPoint(scoreboard2);

        assertThat(scoreboard1.toList()).containsExactly(2, 1);
    }

    @DisplayName("문자열 파싱")
    @Nested
    class to_string {
        @Test
        void 낫싱() {
            Scoreboard scoreboard = new Scoreboard(0, 0);

            assertThat(scoreboard.toString()).isEqualTo("낫싱");
        }

        @Test
        void 원스트라이크() {
            Scoreboard scoreboard = new Scoreboard(0, 1);

            assertThat(scoreboard.toString()).isEqualTo("1스트라이크");
        }

        @Test
        void 투스트라이크() {
            Scoreboard scoreboard = new Scoreboard(0, 2);

            assertThat(scoreboard.toString()).isEqualTo("2스트라이크");
        }

        @Test
        void 쓰리스트라이크() {
            Scoreboard scoreboard = new Scoreboard(0, 3);

            assertThat(scoreboard.toString()).isEqualTo("3스트라이크");
        }

        @Test
        void 원볼() {
            Scoreboard scoreboard = new Scoreboard(1, 0);

            assertThat(scoreboard.toString()).isEqualTo("1볼");
        }

        @Test
        void 원볼_원스트라이크() {
            Scoreboard scoreboard = new Scoreboard(1, 1);

            assertThat(scoreboard.toString()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        void 원볼_투스트라이크() {
            Scoreboard scoreboard = new Scoreboard(1, 2);

            assertThat(scoreboard.toString()).isEqualTo("1볼 2스트라이크");
        }

        @Test
        void 투볼() {
            Scoreboard scoreboard = new Scoreboard(2, 0);

            assertThat(scoreboard.toString()).isEqualTo("2볼");
        }

        @Test
        void 투볼_원스트라이크() {
            Scoreboard scoreboard = new Scoreboard(2, 1);

            assertThat(scoreboard.toString()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void 쓰리볼() {
            Scoreboard scoreboard = new Scoreboard(3, 0);

            assertThat(scoreboard.toString()).isEqualTo("3볼");
        }
    }
}
