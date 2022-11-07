package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameTest {
    private static Game game;

    @BeforeAll
    static void init() {
        game = new Game();
    }

    @Test
    void testCompareListAndAnswer() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        assertRandomNumberInRangeTest(
                () ->{
                    game.init();
                    game.compareListAndAnswer(input);
                    assertEquals(3, game.getStrike());
                }, 1, 3, 5);
    }

}
