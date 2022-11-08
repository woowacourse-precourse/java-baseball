package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Nested
    @DisplayName("입력 예외 테스트")
    class ExceptionTest {
        @Test
        @DisplayName("3자리 이상의 수")
        void 예외_테스트_1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("3자리 미만의 수")
        void 예외_테스트_2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("0을 포함한 수")
        void 예외_테스트_3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("012"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("공백을 포함한 수")
        void 예외_테스트_4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1 2"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("영문자")
        void 예외_테스트_5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 수")
        void 예외_테스트_6() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("올바른 입력후 공백")
        void 예외_테스트_7() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("123 "))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("재시작 예외 테스트")
    class ReGameExceptionTest {
        @Test
        @DisplayName("공백 문자")
        void 재시작_예외_테스트1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("789", " "))
                                .isInstanceOf(IllegalArgumentException.class);
                    },
                    7, 8, 9
            );
        }

        @Test
        @DisplayName("영문자")
        void 재시작_예외_테스트2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("789", "hello world"))
                                .isInstanceOf(IllegalArgumentException.class);
                    },
                    7, 8, 9
            );
        }

        @Test
        @DisplayName("1, 2가 아닌 수")
        void 재시작_예외_테스트3() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("789", "3"))
                                .isInstanceOf(IllegalArgumentException.class);
                    },
                    7, 8, 9
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
