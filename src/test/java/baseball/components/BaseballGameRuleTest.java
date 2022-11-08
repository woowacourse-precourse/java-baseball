package baseball.components;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameRuleTest {

    @Test
    @DisplayName("1. 0ball 0strike")
    void nothingTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(4, 5, 6);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        List<Integer> result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertThat(result).isEqualTo(List.of(0, 0));
    }

    @Test
    @DisplayName("2. 2ball 1strike")
    void strikeAndBallTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 3, 2);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        List<Integer> result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertThat(result).isEqualTo(List.of(2, 1));
    }

    @Test
    @DisplayName("2. 0ball 3strike")
    void threeStrikeTest(){
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 2, 3);

        BaseballGameRule baseballGameRule = new BaseballGameRule();
        baseballGameRule.setComputerNumbers(computerNumbers);

        List<Integer> result = baseballGameRule.generatePlayerScore(playerNumbers);

        assertThat(result).isEqualTo(List.of(0, 3));
    }
}