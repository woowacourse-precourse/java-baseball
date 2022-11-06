package baseball;

import baseball.model.GameResult;
import baseball.service.GameService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {
    static GameService gameService;

    @BeforeAll
    static void setup() {
        gameService = new GameService();
    }

    @Test
    void test() {
        gameService.setGameNumber("713");
        GameResult result = gameService.judge("123");
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);

        result = gameService.judge("145");
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);

        result = gameService.judge("671");
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(0);

        result = gameService.judge("216");
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);

        result = gameService.judge("713");
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
    }
}
