package baseball.view;

import baseball.model.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BaseballViewTest {
    private final BaseballView baseBallView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    BaseballViewTest() {
        this.baseBallView = new BaseballView();
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_문구_출력() {
        baseBallView.showStart();
        assertEquals("숫자 야구 게임을 시작합니다.\n", output.toString());
    }

    @Test
    void 게임_시작_문구_출력_실패() {
        baseBallView.showStart();
        assertNotEquals("숫자 축구 게임을 시작합니다.\n", output.toString());
    }

    @Test
    void 숫자_입력_문구_출력() {
        baseBallView.showInput();
        assertEquals("숫자를 입력해주세요 : ", output.toString());
    }

    @Test
    void 숫자_입력_문구_출력_실패() {
        baseBallView.showInput();
        assertNotEquals("문자를 입력해주세요 : ", output.toString());
    }

    @Test
    void 점수_출력_테스트() {
        baseBallView.showScore(new Score(1, 2));
        assertEquals("1볼 2스트라이크\n", output.toString());
    }

    @Test
    void 종료_출력_테스트() {
        baseBallView.showContinueOrStop();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", output.toString());
    }

}