package baseball.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputUtilTest {
    private OutputStream output;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @ParameterizedTest(name = "inputValue: {arguments}")
    @ValueSource(strings = {"123", "456", "789"})
    void 유저_정답_입력(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String answer = UserInputUtil.readUserAnswer();

        assertEquals(input, answer);
    }

    @ParameterizedTest(name = "inputValue: {arguments}")
    @ValueSource(strings = {"1", "2"})
    void 유저_재시작_입력(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String restartAnswer = UserInputUtil.readRestartAnswer();

        assertEquals(input, restartAnswer);
    }
}