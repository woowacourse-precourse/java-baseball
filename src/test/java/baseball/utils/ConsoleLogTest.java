package baseball.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleLogTest extends NsTest {
    @Test
    @DisplayName("사용자 입력테스트")
    void 사용자_입력테스트() {
        // given
        run("123");

        // when
        List<Integer> userInput = ConsoleLog.input("message");

        // then
        assertThat(output()).contains("message");
        assertEquals(List.of(1,2,3),userInput);
    }

    @Override
    protected void runMain() {

    }
}