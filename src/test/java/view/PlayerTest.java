package view;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void 게임_시작_메시지() {
        String result = "숫자 야구 게임을 시작합니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Player.startPhrase();
        assertThat(out.toString().trim()).isEqualTo(result);
    }

    @Test
    void 사용자_입력() {
        String input = "123";
        String result = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(Player.numberInput()).isEqualTo(result);
    }

}
