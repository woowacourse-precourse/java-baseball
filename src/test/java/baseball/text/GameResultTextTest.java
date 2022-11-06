package baseball.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTextTest {
    @Test
    void 낫싱() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResultText.print(0, 0);

        Assertions.assertThat(out.toString()).isEqualTo("낫싱\n");

    }

    @Test
    void 볼1() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResultText.print(1, 0);

        Assertions.assertThat(out.toString()).isEqualTo("1볼\n");

    }

    @Test
    void 볼1_스트라이크2() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResultText.print(1, 2);

        Assertions.assertThat(out.toString()).isEqualTo("1볼 2스트라이크\n");

    }

    @Test
    void 정답() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResultText.print(0, 3);
        Assertions.assertThat(out.toString())
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

    }
}