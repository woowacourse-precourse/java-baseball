package baseball.components;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballGameRuleTest {

    @Test
    @DisplayName("1. 0ball 0strike")
    void nothingTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(4, 5, 6);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        Score result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertAll(
                () -> assertThat(result.getBall()).isEqualTo(0),
                () -> assertThat(result.getStrike()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("2. 2ball 1strike")
    void strikeAndBallTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 3, 2);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        Score result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertAll(
                () -> assertThat(result.getBall()).isEqualTo(2),
                () -> assertThat(result.getStrike()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("2. 0ball 3strike")
    void threeStrikeTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 2, 3);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        Score result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertAll(
                () -> assertThat(result.getBall()).isEqualTo(0),
                () -> assertThat(result.getStrike()).isEqualTo(3)
        );
    }
}