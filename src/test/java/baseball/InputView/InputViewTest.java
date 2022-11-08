package baseball.InputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private static final String GAME_START_MESSAGE="숫자 야구 게임을 시작합니다.";
    @Test
    public void notice_Start_Message(){

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(GAME_START_MESSAGE);
        Assertions.assertThat(GAME_START_MESSAGE).isEqualTo(out.toString());
    }
}
