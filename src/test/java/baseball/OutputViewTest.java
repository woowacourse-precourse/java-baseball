package baseball;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.View.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        out.reset();
    }

    @Test
    @DisplayName("스트라이크와 볼 개수에 따라 힌트를 잘 출력하는지")
    void printHintMsgTest() {
        int[][] results = {{0, 0}, {3, 0}, {1, 2}, {0, 2}};
        List<String> hintMsg = Arrays.asList("낫싱", "3스트라이크", "2볼 1스트라이크", "2볼");
        for (int iter = 0; iter < 4; iter++) {
            printHintMsg(results[iter]);
            assertThat(out.toString()).contains(hintMsg.get(iter));
            out.reset();
        }
    }
}
