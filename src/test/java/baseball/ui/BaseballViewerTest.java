package baseball.ui;

import baseball.domain.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BaseballViewerTest {
    private final BaseballViewer baseballViewer = new BaseballViewer();
    private PrintStream standardOut;
    private OutputStream output;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_문구_출력() {
        baseballViewer.showStartText();
        assertEquals("숫자 야구 게임을 시작합니다.\n", output.toString());
    }

    @Test
    void 게임_시작_문구_출력_실패() {
        baseballViewer.showStartText();
        assertNotEquals("숫자 축구 게임을 시작합니다.\n", output.toString());
    }

    @Test
    void 숫자_입력_문구() {
        baseballViewer.showInputText();
        assertEquals("숫자를 입력해주세요 : ", output.toString());
    }

    @Test
    void 숫자_입력_문구_출력_실패() {
        baseballViewer.showInputText();
        assertNotEquals("문자를 입력해주세요 : ", output.toString());
    }

    @Test
    void 점수_출력_테스트() {
        Score score = new Score(1, 2);
        baseballViewer.showScore(score);
        assertAll(
                () -> assertEquals("1볼 2스트라이크\n", output.toString()),
                () -> assertNotEquals("2볼 1스트라이크\n", output.toString())
        );
    }

    @Test
    void 종료_출력_테스트() {
        baseballViewer.showWinText();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", output.toString());
    }

    @Test
    void 재시작_출력_테스트() {
        baseballViewer.showRestartGameText();
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", output.toString());
    }
}
