package FunctionTest;

import baseball.Util.InputHandler;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class UserInputTest {
    @Test
    void 인풋테스트() {
        assertThat(InputHandler.getUserInput()).isEqualTo("r");

    }
}
