package baseball.View;

import static org.assertj.core.api.Assertions.*;

import baseball.Util.Constant;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void gameStart_게임시작_문구_출력() {
        String input = Constant.GAME_START;
        Consumer<String> consumer = System.out::println;
        consumer.accept(input);
        assertThat(outputStream.toString().trim()).isEqualTo(Constant.GAME_START);
    }

    @Test
    void inputMessage_입력값_문구_출력() {
        String input = "345";
        String format = String.format(Constant.USER_INPUT, input);
        Consumer<String> consumer = System.out::println;
        consumer.accept(format);
        assertThat(outputStream.toString().trim()).isEqualTo("숫자를 입력해주세요 : 345");
    }

    @Test
    void hintMessage_힌트_메시지_출력() {
        String input = Constant.HINT_STRIKE;
        Consumer<String> consumer = System.out::println;
        consumer.accept(input);
        assertThat(outputStream.toString().trim()).isEqualTo("스트라이크");
    }
}