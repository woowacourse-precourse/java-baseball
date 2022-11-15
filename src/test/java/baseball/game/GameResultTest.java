package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    public void 문자열_변환_테스트() {
        GameResult result = new GameResult(1, 1);
        String resultString = result.convertToString();
        assertThat(resultString).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 전부_스트라이크() {
        GameResult result = new GameResult(0, 3);
        String resultString = result.convertToString();
        assertThat(resultString).isEqualTo("3스트라이크");
    }
}
