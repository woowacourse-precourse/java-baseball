package baseball.process;

import baseball.model.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ComparisonTest {
    Comparison comparison;

    public ComparisonTest(){
        Game game = new Game();
        game.setUserInputNumber(123);
        game.setRandomNumber(456);

        this.comparison = new Comparison(game, 3);
    }

    @Test
    void 숫자를_리스트로(){
        int number = 789;
        List<Integer> resultList = List.of(7, 8, 9);

        Assertions.assertThat(comparison.numberToList(number)).isEqualTo(resultList);
    }
}