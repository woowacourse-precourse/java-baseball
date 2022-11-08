package baseball.view;

import baseball.message.ProgramMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BaseballGameViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BaseballGameView baseballGameView = new BaseballGameView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(standardOut);
    }

    @DisplayName("출력 - \"숫자 야구 게임을 시작합니다.\" 출력후 줄 바꿈")
    @Test
    void displayGameStart() {
        baseballGameView.displayGameStart();
        Assertions.assertThat(ProgramMessage.START_MESSAGE).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @DisplayName("출력 - \"숫자를 입력 해 주세요 : \" 출력")
    @Test
    void displayPleaseEnterNumber() {
        baseballGameView.displayPleaseEnterNumber();
        Assertions.assertThat(ProgramMessage.PLEASE_ENTER_NUMBER).isEqualTo(outputStreamCaptor.toString());
    }

    @DisplayName("게임 종료시 \"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\" 출력후 줄 바꿈")
    @Test
    void 게임_종료시_새로시작_묻는_메시지_출력() {
        baseballGameView.displayAskReStartGame();
        Assertions.assertThat(ProgramMessage.ASK_RESTART_GAME).isEqualTo(outputStreamCaptor.toString().trim());
    }

}