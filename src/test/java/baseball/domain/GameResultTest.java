package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.number.BaseballNumbers;
import baseball.domain.number.NumberGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private static final NumberGenerator numberGenerator = new TestNumberGenerator();
    private static BaseballGame baseballGame;

    @BeforeAll
    static void init() {
        baseballGame = new BaseballGame(numberGenerator);
    }

    @Test
    void makeMessage_낫싱_일때_올바른_메세지() {
        BaseballNumbers userNumbers = new BaseballNumbers(Arrays.asList(4,5,6));
        baseballGame.playRound(userNumbers);
        GameResult result = new GameResult(baseballGame);
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }

    @Test
    void makeMessage_볼_일때_올바른_메세지() {
        BaseballNumbers userNumbers = new BaseballNumbers(Arrays.asList(3,1,2));
        baseballGame.playRound(userNumbers);
        GameResult result = new GameResult(baseballGame);
        assertThat(result.getMessage()).isEqualTo("3볼");
    }

    @Test
    void makeMessage_스트라이크_일때_올바른_메세지() {
        BaseballNumbers userNumbers = new BaseballNumbers(Arrays.asList(1,5,6));
        baseballGame.playRound(userNumbers);
        GameResult result = new GameResult(baseballGame);
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @Test
    void makeMessage_스트라이크_와_볼_일때_올바른_메세지() {
        BaseballNumbers userNumbers = new BaseballNumbers(Arrays.asList(1,3,2));
        baseballGame.playRound(userNumbers);
        GameResult result = new GameResult(baseballGame);
        assertThat(result.getMessage()).isEqualTo("2볼 1스트라이크");
    }

    static class TestNumberGenerator implements NumberGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1,2,3);
        }
    }
}