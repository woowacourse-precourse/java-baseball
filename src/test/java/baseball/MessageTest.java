package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void 게임_시작_문구를_출력하는_기능() {
        Message.GAME_START.print();

        assertEquals("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 숫자_입력_안내_문구를_출력하는_기능() {
        Message.INPUT_NUMBER.print();

        assertEquals("숫자를 입력해주세요 :", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 게임_종료_문구를_출력하는_기능() {
        Message.GAME_OVER.print();

        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());
    }
    @Test
    public void 게임_재시작_의사를_묻는_문구를_출력하는_기능() {
        Message.ASK_RESTART.print();

        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", outputStreamCaptor.toString().trim());
    }
}
