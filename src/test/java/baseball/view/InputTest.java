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

    @Test
    void 입력_테스트() {
        input = new Input();
        String inputMessage = "132";
        InputStream in = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(in);

        input.suggestNumber();
        assertThatNoException();
    }
}
