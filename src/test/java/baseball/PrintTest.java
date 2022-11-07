package baseball;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrintTest {
    Print_function Print = new Print_function();

    @Test
    void start_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print.start_sentence();
        assertThat(out.toString().trim()).isEqualTo("숫자야구 게임을 시작합니다.");
    }

    @Test
    void input_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print.input_sentence();
        assertThat(out.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void input_number_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input_number = "135";

        Print.input_number_sentence(input_number);
        assertThat(out.toString().trim()).isEqualTo("135");
    }

    @Test
    void result_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Integer ball = 0;
        Integer strike = 0;

        Print.result_sentence(ball, strike);
        assertThat(out.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void correct_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print.correct_sentence();
        assertThat(out.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void restart_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print.restart_sentence();
        assertThat(out.toString().trim()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    void restart_integer_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Integer input_number = 2;

        Print.restart_integer_sentence(input_number);
        assertThat(out.toString().trim()).isEqualTo("2");
    }

    @Test
    void end_sentence_test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print.end_sentence();
        assertThat(out.toString().trim()).isEqualTo("숫자야구 게임을 종료합니다.");
    }
}
