package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BaseBallViewTest {
    private final BaseBallView baseBallView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    BaseBallViewTest() {
        this.baseBallView = new BaseBallView();
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
        baseBallView.showBaseBallStartView();
        Assertions.assertEquals("숫자 야구 게임을 시작합니다.\n", output.toString());
    }
}