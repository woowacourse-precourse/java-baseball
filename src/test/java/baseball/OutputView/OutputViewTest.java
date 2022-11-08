package baseball.OutputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class OutputViewTest {
    private static final String SUCCESS_MESSAGE="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    @Test
    public void notice_Start_Message_Test(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.print(SUCCESS_MESSAGE);
        Assertions.assertThat(SUCCESS_MESSAGE).isEqualTo(out.toString());
    }
}
