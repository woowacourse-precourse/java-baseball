package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.BaseballNumber;
import baseball.exception.InvalidInputException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 숫자 확인")
class BaseballGameInputViewTest {

    @Test
    @DisplayName("올바르지 않은 숫자 입력")
    public void isNotValidInput(){
        // given
        final String input = "111";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // when

        // then
        assertThrows(InvalidInputException.class, BaseballGameInputView::getPlayerNumber);
    }

    @Test
    @DisplayName("올바른 숫자 입력")
    public void isValidInput(){
        // given
        final String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final BaseballNumber baseballNumber = new BaseballNumber("123");

        // when
        final BaseballNumber result = BaseballGameInputView.getPlayerNumber();

        // then
        assertEquals(baseballNumber.getBaseballNumber().size(), result.getBaseballNumber().size());
        assertEquals(baseballNumber.getBaseballNumber().get(0), result.getBaseballNumber().get(0));
        assertEquals(baseballNumber.getBaseballNumber().get(1), result.getBaseballNumber().get(1));
        assertEquals(baseballNumber.getBaseballNumber().get(2), result.getBaseballNumber().get(2));
    }
}