package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_메시지_테스트() {
        Printer.gameStartMessage();
        String gameStartMessage = "숫자 야구 게임을 시작합니다.\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(gameStartMessage);
    }

    @Test
    void 숫자_입력_메시지_테스트() {
        Printer.gameInputMessage();
        String gameInputMessage = "숫자를 입력해주세요 : ";
        assertThat(outputStreamCaptor.toString()).isEqualTo(gameInputMessage);
    }

    @Test
    void 게임_종료_메시지_테스트() {
        Printer.gameEndMessage();
        String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(gameEndMessage);
    }

    @Test
    void 게임_재시작_입력_테스트() {
        Printer.gameRestartMessage();
        String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(restartMessage);
    }

    @Test
    void 힌트_메시지_테스트_낫싱() {
        int strike = 0;
        int ball = 0;

        Printer.hintMessage(ball, strike);
        String hintMessage = "낫싱\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(hintMessage);
    }

    @Test
    void 힌트_메시지_테스트_볼() {
        int strike = 0;
        int ball = 1;

        Printer.hintMessage(ball, strike);
        String hintMessage = "1볼\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(hintMessage);
    }

    @Test
    void 힌트_메시지_테스트_스트라이크() {
        int strike = 1;
        int ball = 0;

        Printer.hintMessage(ball, strike);
        String hintMessage = "1스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(hintMessage);
    }

    @Test
    void 힌트_메시지_테스트_볼_스트라이크() {
        int strike = 1;
        int ball = 1;

        Printer.hintMessage(ball, strike);
        String hintMessage = "1볼 1스트라이크\n";
        assertThat(outputStreamCaptor.toString()).isEqualTo(hintMessage);
    }
}
