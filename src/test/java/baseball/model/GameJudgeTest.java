package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameJudgeTest {

    @Nested
    @DisplayName("게임 결과")
    class GameResult {
        @Test
        @DisplayName("볼 판정")
        void ball () {
            List<Integer> player = List.of(1, 8, 3);
            List<Integer> computer = List.of(3, 4, 8);
            String result = "2볼";
            assertThat(GameJudge.judgeGameResult(player, computer)).isEqualTo(result);
        }

        @Test
        @DisplayName("스트라이크 판정")
        void strike () {
            List<Integer> player = List.of(5, 3, 9);
            List<Integer> computer = List.of(5, 7, 9);
            String result = "2스트라이크";
            assertThat(GameJudge.judgeGameResult(player, computer)).isEqualTo(result);
        }

        @Test
        @DisplayName("볼 + 스트라이크 판정")
        void ballAndStrike () {
            List<Integer> player = List.of(1, 6, 5);
            List<Integer> computer = List.of(6, 1, 5);
            String result = "2볼 1스트라이크";
            assertThat(GameJudge.judgeGameResult(player, computer)).isEqualTo(result);
        }

        @Test
        @DisplayName("낫싱 판정")
        void nothing () {
            List<Integer> player = List.of(1, 2, 3);
            List<Integer> computer = List.of(7, 4, 8);
            String result = "낫싱";
            assertThat(GameJudge.judgeGameResult(player, computer)).isEqualTo(result);
        }
    }
}
