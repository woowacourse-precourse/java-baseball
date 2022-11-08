package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Nested
    class GameTest {
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
        void 게임종료_후_재시작_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("325", "145", "1", "847", "254", "1", "742", "2");
                        assertThat(output()).contains("1스트라이크", "3스트라이크", "1볼", "3스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 4, 5, 2, 5, 4, 7, 4, 2
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
