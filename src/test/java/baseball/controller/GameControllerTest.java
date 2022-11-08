package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameControllerTest extends NsTest {

    @Test
    void 잘못된_값_입력() {
        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(() -> {
                    run("2435");
                }, 1, 3, 5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "567", "946", "549", "945", "1", "123", "2");
                    assertThat(output()).contains("낫싱", "2볼", "1볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                9, 4, 5, 1, 2, 3
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
