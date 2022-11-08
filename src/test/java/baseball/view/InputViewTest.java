package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    void inputFromUser(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 숫자입력_테스트() {
        inputFromUser("123");

        int inputNumber = InputView.getNumber();
        assertThat(inputNumber).isEqualTo(123);
    }

    @Test
    void 게임재시작여부입력_테스트() {
        inputFromUser("1");

        int inputNumber = InputView.isReplay();
        assertThat(inputNumber).isEqualTo(1);
    }
}