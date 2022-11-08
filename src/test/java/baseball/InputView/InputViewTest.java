package baseball.InputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private static final String GAME_START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_ENTER_INPUT="숫자를 입력해주세요 : ";

    @Test
    public void notice_Start_Message_Test(){

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(GAME_START_MESSAGE);
        Assertions.assertThat(GAME_START_MESSAGE).isEqualTo(out.toString());
    }
    @Test
    public void request_Entering_Input_Message_Test(){

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(REQUEST_ENTER_INPUT);
        Assertions.assertThat(REQUEST_ENTER_INPUT).isEqualTo(out.toString());
    }
}
