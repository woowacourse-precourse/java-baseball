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
    void 문자입력_예외테스트() {
        inputFromUser("abc");
        Exception exception = assertThrows(IllegalArgumentException.class, InputView::getNumber);
        assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(exception.getMessage()).isEqualTo("숫자를 입력해주세요.");
    }

    @Test
    void 숫자_3자리_예외테스트() {
        inputFromUser("1234");
        Exception exception = assertThrows(IllegalArgumentException.class, InputView::getNumber);
        assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(exception.getMessage()).isEqualTo("숫자 3자리를 입력해주세요.");
    }

    @Test
    void 서로다른숫자_예외테스트() {
        inputFromUser("122");
        Exception exception = assertThrows(IllegalArgumentException.class, InputView::getNumber);
        assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(exception.getMessage()).isEqualTo("서로 다른 숫자 3자리를 입력해주세요.");
    }

    @Test
    void 게임종료시_입력_예외테스트() {
        inputFromUser("3");
        Exception exception = assertThrows(IllegalArgumentException.class, InputView::isReplay);
        assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(exception.getMessage()).isEqualTo("1 또는 2를 입력해주세요.");
    }

}