package baseball.controller;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.BaseballGame;
import baseball.domain.number.BaseballNumbers;
import baseball.domain.number.NumberGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private static final NumberGenerator numbersGenerator = new TestNumberGenerator();
    private static BaseballGame baseballGame;

    @BeforeAll
    static void init() {
        baseballGame = new BaseballGame(numbersGenerator);
    }

    @Test
    void isGameContinue_올바른_반환값() {
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(Arrays.asList(1,2,3));
        baseballGame.playRound(userBaseballNumbers);
        assertThat(baseballGame.isGameContinue()).isEqualTo(false);
    }

    @Test
    void getStrikeCount_올바른_반환값() {
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(Arrays.asList(1,3,2));
        baseballGame.playRound(userBaseballNumbers);
        assertThat(baseballGame.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void getBallCount_올바른_반환값() {
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(Arrays.asList(3,1,2));
        baseballGame.playRound(userBaseballNumbers);
        assertThat(baseballGame.getBallCount()).isEqualTo(3);
    }

    static class TestNumberGenerator implements NumberGenerator {

        @Override
        public List<Integer> generate() {
            return Arrays.asList(1,2,3);
        }
    }
}