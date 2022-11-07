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
        game = new Game();
    }

    @DisplayName("컴퓨터의 수 생성 테스트")
    @Test
    void setComputerNumberTest() {
        assertRandomNumberInRangeTest(() -> {
            game.setComputerNumber();
            List<Integer> testNumber = new ArrayList<>();
            testNumber.add(1);
            testNumber.add(2);
            testNumber.add(3);
            assertThat(game.getComputerNumber()).isEqualTo(testNumber);
        }, 1, 2, 3);
    }

    @DisplayName("유저 입력 메세지 테스트")
    @Test
    void printUserInputPromptTest() {
        game.printUserInputPrompt();
        assertThat(output()).isEqualTo("숫자를 입력해주세요 :");
    }

    }

    @Override
    public void runMain() {
        game.start();
    }
}
