package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("asd"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void generateAnswer_테스트() {
        ArrayList<Integer> result = generateAnswer();
        System.out.println(result);
        assertEquals(result.size(), 3);
    }

    @Test
    void outputInText_테스트 () {
        String outputInText = "";
        int strikeCount = 0;
        int ballCount = 0;
        String result = outputInText(outputInText, strikeCount, ballCount);
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void outputInText_테스트2 () {
        String outputInText = "";
        int strikeCount = 3;
        int ballCount = 0;
        String result = outputInText(outputInText, strikeCount, ballCount);
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void outputInText_테스트3 () {
        String outputInText = "";
        int strikeCount = 2;
        int ballCount = 2;
        String result = outputInText(outputInText, strikeCount, ballCount);
        assertThat(result).isEqualTo("2볼 2스트라이크");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
