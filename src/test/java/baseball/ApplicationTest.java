package baseball;

import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "789", "798", "987", "1","246", "135", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "2볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "낫싱", "3스트라이크");
                },
                9,8,7, 1, 3, 5
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
    void 컴퓨터랜덤값_테스트() {
        Baseball baseball = new Baseball();
        baseball.getGameNumber().stream()
                .map(number -> assertThat(number).isBetween(1,9));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
