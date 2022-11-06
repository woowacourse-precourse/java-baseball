package baseball.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class GameJudgeTest {
    GameJudge judge = new GameJudge();
    @Test
    void 볼_판정() {
        List<Integer> player = List.of(1, 8, 3);
        List<Integer> computer = List.of(3, 4, 8);
        String result = "2볼";
        assertThat(judge.judgeGameResult(player, computer)).isEqualTo(result);
    }
    @Test
    void 스트라이크_판정() {
        List<Integer> player = List.of(5, 3, 9);
        List<Integer> computer = List.of(5, 7, 9);
        String result = "2스트라이크";
        assertThat(judge.judgeGameResult(player, computer)).isEqualTo(result);
    }
    @Test
    void 볼_스트라이크_판정() {
        List<Integer> player = List.of(1, 6, 5);
        List<Integer> computer = List.of(6, 1, 5);
        String result = "2볼 1스트라이크";
        assertThat(judge.judgeGameResult(player, computer)).isEqualTo(result);
    }
    @Test
    void 낫싱_판정() {
        List<Integer> player = List.of(1, 2, 3);
        List<Integer> computer = List.of(7, 4, 8);
        String result = "낫싱";
        assertThat(judge.judgeGameResult(player, computer)).isEqualTo(result);
    }
}
