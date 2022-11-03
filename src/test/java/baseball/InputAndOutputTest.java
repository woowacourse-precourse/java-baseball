package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputAndOutputTest {

    private static final String ENDANSWER_ERR_MESSAGE = "1 혹은 2가 아닙니다.";

    InputAndOutput inputAndOutput = new InputAndOutput();

    @Test
    void 사용자_숫자_입력_받기_검증() {
        String answer = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);

        String userAnswer = InputAndOutput.getUserAnswer();
        Assertions.assertThat(userAnswer).isEqualTo("123");
    }

    @Test
    void 사용자_종료_문구_입력_받기_검증() {
        String endAnswer = "1";
        boolean available = inputAndOutput.isValidEndAnswer(endAnswer);
        Assertions.assertThat(available).isTrue();
    }

    @Test
    void 사용자_종료_문구_입력_유효성_검사_자리수_초과_케이스() {
        String endAnswer = "12";

        assertThatThrownBy(() -> inputAndOutput.isValidEndAnswer(endAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENDANSWER_ERR_MESSAGE);
    }

    @Test
    void 사용자_종료_문구_입력_유효성_검사_자료형_위반_케이스() {
        String endAnswer = "ㄱ";

        assertThatThrownBy(() -> inputAndOutput.isValidEndAnswer(endAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ENDANSWER_ERR_MESSAGE);
    }
}