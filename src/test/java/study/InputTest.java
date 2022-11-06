package study;

import baseball.PlayerNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class InputTest {
    private static PlayerNum playerNumber;
    private static final String msg = "숫자를 입력해주세요 : ";

    @BeforeAll
    static void initAll() {
        playerNumber = new PlayerNum();
    }

    @Test
    void 사용자_입력과_출력이_정상작동하는지_검증() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        playerNumber.createNumber();
        Assertions.assertThat(msg).isEqualTo(out.toString());
    }
}
