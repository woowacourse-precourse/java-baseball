package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testResult1() {
        List<Integer> computer = List.of(1, 2, 3);
        Application.evaluate(computer, Application.playerNumber("456"));
        assertEquals(outputStreamCaptor.toString()
                .trim(), "낫싱");

    }


    @Test
    void testResult2() {
        List<Integer> computer = List.of(1, 2, 3);
        Application.evaluate(computer, Application.playerNumber("138"));
        assertEquals(outputStreamCaptor.toString()
                .trim(), "1볼 1스트라이크");
    }

    @Test
    void testResult3() {
        List<Integer> computer = List.of(1, 2, 3);
        Application.evaluate(computer, Application.playerNumber("923"));
        assertEquals(outputStreamCaptor.toString()
                .trim(), "2스트라이크");
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }


    @Test
     void testException01() {
        assertThatThrownBy(() -> Application.playerNumException(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 01 : 아무것도 입력하지 않았습니다.");
    }

    @Test
    void testException02() {
        assertThatThrownBy(() -> Application.playerNumException("54b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 02 : 숫자 이외의 문자가 포함되어 있습니다.");
    }

    @Test
    void testException03() {
        assertThatThrownBy(() -> Application.playerNumException("890"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 03 : 0이 포함되어 있습니다.");
    }

    @Test
    void testException04() {
        assertThatThrownBy(() -> Application.playerNumException("3571"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 04 : 숫자가 3자리가 아닙니다.");
    }

    @Test
    void testException05() {
        assertThatThrownBy(() -> Application.playerNumber("988"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 05 : 중복되는 숫자가 입력되었습니다.");
    }

    @Test
    void testException06() {
        assertThatThrownBy(() -> Application.exitSequenceException(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 06 : 잘못된 값이 입력되었습니다.");
    }
}