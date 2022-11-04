package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballGameTest {

    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpOut() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_문구를_출력한다() {
        BaseballGame baseballGame = new BaseballGame();
        String result = "숫자 야구 게임을 시작합니다.";

        baseballGame.playGame();

        assertThat(outputStream.toString().trim()).isEqualTo(result);
    }
}
