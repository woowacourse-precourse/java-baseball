package baseball.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest extends NsTest {
    UserInput userInput = UserInput.getInstance();
    @Test
    @DisplayName("사용자 입력이 List로 잘 만들어지는지 테스트")
    void isUserInputToList() {
        // given
        String message = "message";
        run("123");

        // when
        List<Integer> inputToList = userInput.number(message);

        // then
        assertThat(output()).isEqualTo("message");
        assertEquals(3, inputToList.size());
    }

    @Test
    @DisplayName("사용자가 null 입력시 exception 테스트")
    void inputNull() {
        // given
        run("");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 whiteSpace 입력시 exception 테스트")
    void inputWhiteSpace() {
        // given
        run("   ");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력길이를 초과할 시 exception 테스트")
    void inputLengthError() {
        // given
        run("1234");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("세 자리가 아닙니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 0입력시 exception 테스트")
    void input0() {
        // given
        run("120");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("숫자가 아니거나 0이 포함되어 있습니다", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 중복 숫자 입력시 exception 테스트1")
    void inputDuplicatedNumber1() {
        // given
        run("121");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("중복된 숫자가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 중복 숫자 입력시 exception 테스트2")
    void inputDuplicatedNumber2() {
        // given
        run("112");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("중복된 숫자가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사용자가 중복 숫자 입력시 exception 테스트3")
    void inputDuplicatedNumber3() {
        // given
        run("211");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userInput.number(null));
        assertEquals("중복된 숫자가 포함되어 있습니다.", exception.getMessage());
    }

    @Override
    protected void runMain() {

    }
}