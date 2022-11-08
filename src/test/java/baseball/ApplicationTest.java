package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 스트라이크_볼_테스트() {
        int[] strikeBall = new int[2];
        for (int i = 0; i <= 8; ++i) {
            for (int j = 0; j <= 8; ++j) {
                for (int k = 0; k <= 2; ++k) {
                    for (int l = 0; l <= 2; ++l) {
                        int strikeBefore = strikeBall[0], ballBefore = strikeBall[1];
                        Application.addStrikeBall((char)('1'+i), (char)('1'+j), k, l, strikeBall);
                        int strikeAfter = strikeBall[0], ballAfter = strikeBall[1];
                        if (i == j) {
                            if (k == l) {
                                assertThat(strikeAfter - strikeBefore).isEqualTo(1);
                                assertThat(ballAfter - ballBefore).isEqualTo(0);
                            } else {
                                assertThat(strikeAfter - strikeBefore).isEqualTo(0);
                                assertThat(ballAfter - ballBefore).isEqualTo(1);
                            }
                        } else {
                            assertThat(strikeAfter - strikeBefore).isEqualTo(0);
                            assertThat(ballAfter - ballBefore).isEqualTo(0);
                        }
                    }
                }
            }
        }
    }

    @Test
    void 입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.checkInputNumberValidate("112");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.checkInputNumberValidate("1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.checkInputNumberValidate("12a");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
