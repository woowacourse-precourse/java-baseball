package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.View.*;

public class OutputVIewTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        out.reset();
    }

    @Test
    void printHintMsgTest(){
        int[][] results = {{0, 0}, {3, 0}, {1, 2}, {0, 2}};
        String[] hintMsg = {"낫싱", "3스트라이크", "2볼 1스트라이크", "2볼"};
        for (int iter = 0; iter < 4; iter++){
            printHintMsg(results[iter]);
            assertThat(out.toString()).contains(hintMsg[iter]);
            out.reset();
        }
    }
}
