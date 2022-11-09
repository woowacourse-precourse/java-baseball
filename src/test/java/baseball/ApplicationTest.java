package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Nested
    class CompareNumberTest {

        @Test
        void 숫자비교_테스트_스트라이크() {
            int result = Application.compareNumber("356", 2, '6');
            assertThat(result).isEqualTo(1);
        }

        @Test
        void 숫자비교_테스트_볼() {
            int result = Application.compareNumber("356", 1, '6');
            assertThat(result).isEqualTo(2);
        }

        @Test
        void 숫자비교_테스트_낫싱() {
            int result = Application.compareNumber("356", 2, '1');
            assertThat(result).isEqualTo(0);
        }
    }

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

    @Nested
    class MessageTest {

        @Test
        void 게임시작_메시지_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("478", "267", "2");
                        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
                    },
                    2, 6, 7
            );
        }

        @Test
        void 숫자입력_메시지_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("478", "267", "2");
                        assertThat(output()).contains("숫자를 입력해주세요 :");
                    },
                    2, 6, 7
            );
        }

        @Test
        void 게임종료_메시지_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "2");
                        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    },
                    1, 3, 5
            );
        }

        @Test
        void 게임재시작_메시지_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("478", "267", "2");
                        assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    },
                    2, 6, 7
            );
        }
    }

    @Nested
    class ExceptionTest {

        @Test
        void 개수_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 중복_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 범위_예외_테스트_0포함() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("035"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 범위_예외_테스트_문자포함() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("ㄱㅇ3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 범위_예외_테스트_특수문자포함() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("!=3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 재시작_예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> {
                                run("246", "135", "5");
                                assertThat(output()).contains("낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                            },
                            1, 3, 5
                    )).isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
