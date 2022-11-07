package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.List;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest extends NsTest {

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

    @DisplayName("숫자 입력 메세지 출력")
    @Test
    void printUserInputPromptTest() {
        game.printUserInputPrompt();
    }

    @Override
    public void runMain() {
        game.start();
    }
}
