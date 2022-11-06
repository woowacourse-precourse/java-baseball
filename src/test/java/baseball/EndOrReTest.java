package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndOrReTest {

    private static ByteArrayOutputStream outContent;
    private EndOrRe endOrRe;

    @BeforeEach
    public void setEndOrTest() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        endOrRe = new EndOrRe();
    }

    @Test
    void 입력된_값_확인1() {
        String result = "1";
        endOrRe.printInputString(result);
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    void 입력된_값_확인2() {
        String result = "2";
        endOrRe.printInputString(result);
        assertEquals("2", outContent.toString().trim());
    }

    @Test
    void 입력된_값이_1과_2가_아닐_경우() {
        String result = "3";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_영어일_경우() {
        String result = "r";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_10일_경우() {
        String result = "10";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_한글일_경우() {
        String result = "우아한테크코스";
        Assertions.assertThatThrownBy(() -> {
            endOrRe.printInputString(result);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}