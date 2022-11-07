package baseball.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;

    @Test
    void 게임_종료_메시지() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        OutputView.endGameMessage();
        Assertions.assertThat(outputMessage.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

}
