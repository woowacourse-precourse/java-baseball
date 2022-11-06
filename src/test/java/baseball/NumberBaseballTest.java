package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumberBaseballTest")
class NumberBaseballTest extends NsTest {

    @Nested
    @DisplayName("playGame() 관련 테스트")
    final class playGameTest {
        @DisplayName("기본 출력이 제대로 되는지 확인")
        @AfterEach
        void defaultPrintTest() {
            assertThat(output()).contains("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ");
        }

        @DisplayName("3스트라이크에 게임이 종료되는지 확인")
        @Test
        void gameCloseTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "2");
                        assertThat(output()).contains("3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }

        @DisplayName("볼과 스트라이크가 정상적으로 출력되는지 확인")
        @Test
        void ballAndStrikeTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("213", "123", "2");
                        assertThat(output()).contains("2볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }

        @DisplayName("볼이 정상적으로 출력되는지 확인")
        @Test
        void ballTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("415", "123", "2");
                        assertThat(output()).contains("1볼", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }

        @DisplayName("스트라이크가 정상적으로 출력되는지 확인")
        @Test
        void strikeTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("453", "123", "2");
                        assertThat(output()).contains("1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }
    }

    @DisplayName("예외 처리 테스트(IllegalArgumentException)")
    @Nested
    class exceptionTest {
        @DisplayName("playGame() 예외 테스트")
        @Nested
        class playGameExceptionTest {
            @DisplayName("3자리 초과 입력하는 경우")
            @Test
            void playGameInputMoreThenThree() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1234"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @DisplayName("3자리 미만을 입력하는 경우")
            @Test
            void playGameInputLessThenThree() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("12"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @DisplayName("문자가 포함된 입력을 하는 경우")
            @Test
            void playGameIncludeCharacter() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1a1"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @DisplayName("isRestart() 예외 테스트")
        @Nested
        class isRestartExceptionTest {
            @DisplayName("1자리 숫자를 초과하는 경우")
            @Test
            void isRestartMoreOne() {
                assertRandomNumberInRangeTest(
                        () -> {
                            assertSimpleTest(() ->
                                    assertThatThrownBy(() -> run("123", "12"))
                                            .isInstanceOf(IllegalArgumentException.class)
                            );
                        },
                        1, 2, 3
                );
            }

            @DisplayName("1, 2 아닌 숫자를 입력하는 경우")
            @Test
            void isRestartNotOneOrTwo() {
                assertRandomNumberInRangeTest(
                        () -> {
                            assertSimpleTest(() ->
                                    assertThatThrownBy(() -> run("123", "3"))
                                            .isInstanceOf(IllegalArgumentException.class)
                            );
                        },
                        1, 2, 3
                );
            }

            @DisplayName("문자를 입력하는 경우")
            @Test
            void isRestartIncludeCharacter() {
                assertRandomNumberInRangeTest(
                        () -> {
                            assertSimpleTest(() ->
                                    assertThatThrownBy(() -> run("123", "a"))
                                            .isInstanceOf(IllegalArgumentException.class)
                            );
                        },
                        1, 2, 3
                );
            }
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}