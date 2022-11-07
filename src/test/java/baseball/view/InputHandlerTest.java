package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputHandlerTest extends NsTest {
    private InputHandler inputHandler = new InputHandler();

    @Test
    void readGameInputTest() {
        super.run("123");
        assertThat(inputHandler.readGameInput())
                .isEqualTo(123);
    }

    @Test
    void readGameControlInputTest() {
        super.run("1");
        assertThat(inputHandler.readGameControlInput())
                .isEqualTo(1);
    }

    @Override
    public void runMain() {
    }
}
