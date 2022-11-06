package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.Application.getUserInput;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    @ParameterizedTest
    @ValueSource(strings = {"031"})
    void getUserInputTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        List<Integer> userInput = new ArrayList<>();
        userInput.add(0);
        userInput.add(3);
        userInput.add(1);
        assertEquals(userInput,getUserInput());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
