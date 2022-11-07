package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.BaseballNumber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 확인")
class BaseballGameInputViewTest {

    OutputStream out;
    InputStream in;

    @BeforeEach
    public void init() {
        out = new ByteArrayOutputStream();
    }

    @Nested
    @DisplayName("사용자 숫자 입력 검증")
    class PlayerNumberValidation {
        @Test
        @DisplayName("올바르지 않은 숫자 입력")
        public void isNotValidInput() {
            // given
            final String input = "111";
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            // when

            // then
            assertThrows(IllegalArgumentException.class, BaseballGameInputView::getPlayerNumber);
        }

        @Test
        @DisplayName("올바른 숫자 입력")
        public void isValidInput() {
            // given
            final String input = "123";
            System.setOut(new PrintStream(out));
            in = new ByteArrayInputStream(input.getBytes());
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

}