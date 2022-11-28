package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    void gameTest() {
        //given
        Game game = new Game();
        game.setComputerForTest(List.of(2, 5, 3));
        game.setUserNumber("123");
        game.calculateBallAndStrikeResult();

        //when
        List<Integer> result = game.result;
        Integer ballCounts = result.get(0);
        Integer strikeCounts = result.get(1);

        //then
        Assertions.assertThat(1).isEqualTo(ballCounts);
        Assertions.assertThat(1).isEqualTo(strikeCounts);
    }
}
