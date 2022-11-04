package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    @Test
    void printGameStartMessage_test_print_message() {
        Game game = new Game();
        game.printGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
    public void runMain() {

    }
}
