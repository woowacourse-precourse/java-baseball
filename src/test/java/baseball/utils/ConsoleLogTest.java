package baseball.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleLogTest extends NsTest {
    ConsoleLog console = ConsoleLog.getInstance();
    @Test
    @DisplayName("사용자 입력테스트")
    void userInputTest() {
        // given
        String number = "123";

        // when
        run(number);
        String inputNum = console.input();

        // then
        assertEquals("123",inputNum);
    }

    @Test
    @DisplayName("console창 테스트")
    void consoleOutput() {
        // given
        String message = "message";

        // when
        console.print(message);

        // then
        assertThat(output()).isEqualTo("message");
    }

    @Test
    @DisplayName("console창 테스트2")
    void consoleOutput2() {
        // given
        String message = "message";

        // when
        console.println(message);

        // then
        assertThat(output()).isEqualTo("message");
    }

    @Override
    protected void runMain() {

    }
}