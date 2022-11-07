package baseball.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.config.AppConfig;
import baseball.view.Input;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest {
    private Input input;

    @BeforeEach
    void setInput() {
        AppConfig appConfig = new AppConfig();
        input = appConfig.input();
    }

    @Test
    void 입력_테스트() {
        String inputMessage = "232";
        InputStream in = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.suggestNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_테스트2() {
        String inputMessage = "132";
        InputStream in = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(in);

        input.suggestNumber();
        assertThatNoException();
    }

    @Test
    void 재시작_테스트() {
        String restartMessage = "1";
        InputStream in = new ByteArrayInputStream(restartMessage.getBytes());
        System.setIn(in);

        input.continueOrNot();
        assertThatNoException();
    }
}