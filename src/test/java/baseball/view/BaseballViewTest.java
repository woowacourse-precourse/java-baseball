package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Assertions.assertEquals("숫자 야구 게임을 시작합니다.\n", output.toString());
    }

    @Test
    void 게임_시작_문구_출력_실패() {
        baseBallView.showStart();
        Assertions.assertNotEquals("축구 게임\n", output.toString());
    }

    @Test
    void 숫자_입력_문구_출력() {
        baseBallView.showInput();
        Assertions.assertEquals("숫자를 입력해주세요 : ", output.toString());
    }

    @Test
    void 숫자_입력_문구_출력_실패() {
        baseBallView.showInput();
        Assertions.assertNotEquals("문자를 입력해주세요 : ", output.toString());
    }
}