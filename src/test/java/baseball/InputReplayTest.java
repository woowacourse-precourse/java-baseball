package baseball;

import baseball.input.InputReplay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력이 1이나 2가 아닐경우 throw")
public class InputReplayTest {
    @Test
    void case1() {
        InputReplay inputReplay = new InputReplay();
        String testStr = "1111";
        final byte[] buf = testStr.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(() -> inputReplay.input(1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case2() {
        InputReplay inputReplay = new InputReplay();
        String testStr = "3";
        final byte[] buf = testStr.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(() -> inputReplay.input(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case3() {
        InputReplay inputReplay = new InputReplay();
        String testStr = "0";
        final byte[] buf = testStr.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(() -> inputReplay.input(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case4() {
        InputReplay inputReplay = new InputReplay();
        String testStr = "q";
        final byte[] buf = testStr.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(() -> inputReplay.input(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
