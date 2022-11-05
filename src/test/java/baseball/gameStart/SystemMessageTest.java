package baseball.gameStart;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.view.SystemMessage;

public class SystemMessageTest {

    @Test
    void print_game_start_message_test() {
        String result = "숫자 야구 게임을 시작합니다.\n";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        SystemMessage.printGameStart();
        Assertions.assertThat(result).isEqualTo(out.toString());
    }
}
