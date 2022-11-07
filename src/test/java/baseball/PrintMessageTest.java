package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class PrintMessageTest {

    @Test
    void startMessage() {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.startMessage();
        String start = "숫자 야구 게임을 시작합니다.\n";
        assertThat(outPut.toString()).isEqualTo(start);
    }

    @Test
    void inputMessage() {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.inputMessage();
        String input = "숫자를 입력해주세요 : ";
        assertThat(outPut.toString()).isEqualTo(input);
    }

    @Test
    void ballStrikeMessage() {

    }

    @Test
    void answerMessage() {
    }

    @Test
    void gameContinueMessage() {
    }
}