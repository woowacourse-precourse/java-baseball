package baseball.utils;

import baseball.model.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class RandomNumberTest {
    RandomNumber randomNumber;

    public RandomNumberTest(){
        Game game = new Game();
        randomNumber = new RandomNumber(game, 3);
    }

    @Test
    void 숫자_리스트에서_숫자로_변환(){
        int result = 123;
        List<Integer> numList = List.of(1, 2, 3);

        Assertions.assertThat(randomNumber.numListToIntValue(numList)).isEqualTo(result);
    }
}