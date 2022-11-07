package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        this.game = new Game();
    }

    @DisplayName("3자리 수 생성")
    @Test
    void getComputerNumberTest() {
        List<Integer> testComputerNumber = new ArrayList<>();
        testComputerNumber.add(1);
        testComputerNumber.add(2);
        testComputerNumber.add(3);
        assertRandomNumberInRangeTest(() -> {
            game.getComputerNumber();
            assertThat(game.getComputerNumber()).isEqualTo(testComputerNumber);
        }, 1, 2, 3);
    }

}
