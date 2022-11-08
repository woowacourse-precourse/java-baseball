package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void requestInputMessage() {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.requestInputMessage();
        String input = "숫자를 입력해주세요 : ";
        assertThat(outPut.toString()).isEqualTo(input);
    }

    @Test
    void ballStrikeMessage_nothing() {
        List<Integer> ballStrike = new ArrayList<>(Arrays.asList(0, 0));
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.ballStrikeMessage(ballStrike.get(0), ballStrike.get(1));
        assertThat(outPut.toString()).isEqualTo("낫싱\n");
    }
    @Test
    void ballStrikeMessage_only_strike() {
        List<Integer> ballStrike = new ArrayList<>(Arrays.asList(0, 2));
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.ballStrikeMessage(ballStrike.get(0), ballStrike.get(1));
        assertThat(outPut.toString()).isEqualTo("2스트라이크\n");
    }
    @Test
    void ballStrikeMessage_only_ball() {
        List<Integer> ballStrike = new ArrayList<>(Arrays.asList(3, 0));
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.ballStrikeMessage(ballStrike.get(0), ballStrike.get(1));
        assertThat(outPut.toString()).isEqualTo("3볼\n");
    }
    @Test
    void ballStrikeMessage_mixed() {
        List<Integer> ballStrike = new ArrayList<>(Arrays.asList(2, 1));
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.ballStrikeMessage(ballStrike.get(0), ballStrike.get(1));
        assertThat(outPut.toString()).isEqualTo("2볼 1스트라이크\n");
    }
    @Test
    void resultMessage() {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.resultMessage();
        String input = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        assertThat(outPut.toString()).isEqualTo(input);
    }

    @Test
    void askContinueMessage() {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        PrintMessage.askContinueMessage();
        String gameContinue = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        assertThat(outPut.toString()).isEqualTo(gameContinue);
    }
}