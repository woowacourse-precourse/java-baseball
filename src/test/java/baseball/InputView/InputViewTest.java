package baseball.InputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private static final String GAME_START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_ENTER_INPUT="숫자를 입력해주세요 : ";
    private static final String REQUEST_SELECT_NEW_GAME_OR_END="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


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
    @Test
    public void request_Entering_Input_Want_More_Game_OR_End_Message_Test(){

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(REQUEST_SELECT_NEW_GAME_OR_END);
        Assertions.assertThat(REQUEST_SELECT_NEW_GAME_OR_END).isEqualTo(out.toString());
    }
}
