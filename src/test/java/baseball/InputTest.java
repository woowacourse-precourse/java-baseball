package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import baseball.view.Input;

public class InputTest {

    @Test
    void Input_정상_세자리숫자입력() {
        Input input = new Input();
        String answer = "123";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        String result = input.threeNumber();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void Input_오류생성_네자리값입력() {
        Input input = new Input();
        String answer = "1234";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::threeNumber)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Input_오류생성_두자리값입력() {
        Input input = new Input();
        String answer = "12";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::threeNumber)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Input_게임계속하기_true_1를입력() {
        Input input = new Input();
        boolean answer = true;
        InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        boolean result = input.continueGame();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void Input_게임계속하기_false_2를입력() {
        Input input = new Input();
        boolean answer = false;
        InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        boolean result = input.continueGame();
        assertThat(result).isEqualTo(answer);
    }
}
