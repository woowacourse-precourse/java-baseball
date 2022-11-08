package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.util.GameCode;
import baseball.util.InputUtility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest {

    void writeConsole(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void test_공격입력_자연수가_아닌_문자열_에러처리() {
        writeConsole("012");
        assertThatThrownBy(() -> InputUtility.readLine(GameCode.ATTACK.getValue()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_공격입력_문자열_길이_3이하() {
        writeConsole("1");
        assertThatThrownBy(() -> InputUtility.readLine(GameCode.ATTACK.getValue()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void test_공격입력_문자열_길이_3이상() {
        writeConsole("1234");
        assertThatThrownBy(() -> InputUtility.readLine(GameCode.ATTACK.getValue()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void test_공격입력_중복문자존재() {
        writeConsole("112");
        assertThatThrownBy(() -> InputUtility.readLine(GameCode.ATTACK.getValue()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void test_진행입력_1_2_이외의_문자입력() {
        writeConsole("3");
        assertThatThrownBy(() -> InputUtility.readLine(GameCode.CONTINUE.getValue()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void test_문자열파싱() {
        List<Integer> result = InputUtility.parsingNumber("123");
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));

    }

}
