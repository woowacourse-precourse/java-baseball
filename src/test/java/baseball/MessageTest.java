package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {
    Message message = new Message();
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void before() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void after() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    void 게임_시작_문구를_확인한다() {
        message.printInitialGameStartMessage();

        String result = "숫자 야구 게임을 시작합니다.";
        assertThat(result).isEqualTo(getOutputString());
    }

    @Test
    void 숫자_입력_문구를_확인한다() {
        message.printInputNumbersMessage();

        String result = "숫자를 입력해주세요. : ";
        assertThat(result).isEqualTo(outputStream.toString());
    }

    @Test
    void 스트라이크_문구를_확인한다() {
        message.printStrikeMessage();

        String result = "스트라이크 ";
        assertThat(result).isEqualTo(outputStream.toString());
    }

    @Test
    void 볼_문구를_확인한다() {
        message.printBallMessage();

        String result = "볼 ";
        assertThat(result).isEqualTo(outputStream.toString());
    }

    @Test
    void 낫싱_문구를_확인한다() {
        message.printNothingMessage();

        String result = "낫싱";
        assertThat(result).isEqualTo(getOutputString());
    }

    @Test
    void 스트라이크_3개_게임_종료_문구를_확인한다() {
        message.printGameEndMessage();

        String result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertThat(result).isEqualTo(getOutputString());
    }

    @Test
    void 재시작_여부_묻는_문구를_확인한다() {
        message.printRestartOrEndMessage();

        String result = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        assertThat(result).isEqualTo(getOutputString());
    }

    @Test
    void 게임_완전_종료_문구를_확인한다() {
        message.printGameOverMessage();

        String result = "게임 종료";
        assertThat(result).isEqualTo(getOutputString());
    }

    String getOutputString() {
        String output = outputStream.toString().trim();
        return output;
    }
}