package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
                                1, 3, 5, 5, 8, 9);
        }

        @Nested
        class IllegalArgumentException_Test {
                @Test
                void 사용자의_입력이_3자리가_아닐때() {
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234"))
                                        .isInstanceOf(IllegalArgumentException.class));
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("12"))
                                        .isInstanceOf(IllegalArgumentException.class));
                }

                @Test
                void 사용자의_입력이_1에서_9사이의_숫자가_아닐때() {
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("ABC"))
                                        .isInstanceOf(IllegalArgumentException.class));
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("12A"))
                                        .isInstanceOf(IllegalArgumentException.class));
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("120"))
                                        .isInstanceOf(IllegalArgumentException.class));
                }

                @Test
                void 사용자의_입력에_중복된_수가_있을때() {
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("122"))
                                        .isInstanceOf(IllegalArgumentException.class));
                        assertSimpleTest(() -> assertThatThrownBy(() -> runException("333"))
                                        .isInstanceOf(IllegalArgumentException.class));
                }

                @Test
                void 게임종료_후_1_또는_2를_입력하지_않았을때() {
                        assertRandomNumberInRangeTest(
                                        () -> assertThatThrownBy(() -> runException("135", "3"))
                                                        .isInstanceOf(IllegalArgumentException.class),
                                        1, 3, 5);

                        assertRandomNumberInRangeTest(
                                        () -> assertThatThrownBy(() -> runException("135", "RESTART"))
                                                        .isInstanceOf(IllegalArgumentException.class),
                                        1, 3, 5);
                }

        }

        @Override
        public void runMain() {
                Application.main(new String[] {});
        }
}
