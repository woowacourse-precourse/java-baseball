package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import baseball.view.Input;

public class InputValidateTest {

    @Test
    void input_정답_세자리숫자입력() {
        Input input = new Input();
        String answer = "123";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        String result = input.inputNumber();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void input_오답_네자리숫자입력() {
        Input input = new Input();
        String answer = "1234";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::inputNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_오답_문자입력() {
        Input input = new Input();
        String answer = "a12";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::inputNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_오답_두글자입력() {
        Input input = new Input();
        String answer = "12";
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::inputNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_1입력() {
        Input input = new Input();
        String answer = "1";
        InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        String result = input.inputExit();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void input_2입력() {
        Input input = new Input();
        String answer = "2";
        InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        String result = input.inputExit();
        assertThat(result).isEqualTo(answer);
    }
}
