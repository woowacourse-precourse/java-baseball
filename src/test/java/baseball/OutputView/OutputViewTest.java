package baseball.OutputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class OutputViewTest {
    private static final String SUCCESS_MESSAGE="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STATE_MESSAGE="1볼 1스트라이크";
    @Test
    public void show_Success_Message_Test(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(SUCCESS_MESSAGE);
        Assertions.assertThat(SUCCESS_MESSAGE).isEqualTo(out.toString());
    }
    @Test
    public void Show_State_Message_Test(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(SUCCESS_MESSAGE);
        Assertions.assertThat(SUCCESS_MESSAGE).isEqualTo(out.toString());
    }
}
