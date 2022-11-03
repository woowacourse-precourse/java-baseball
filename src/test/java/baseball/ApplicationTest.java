package baseball;

import static baseball.BaseballGameLauncher.GAME_START_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {


    @DisplayName("게임 시작시 게임 시작 문구를 출력한다.")
    @Test
    void case1() {
        assertSimpleTest(() ->
                assertThat(output().startsWith(GAME_START_MESSAGE)));
    }



    @Nested
    @DisplayName("만약 플레이어가 입력한 값이")
    class ExceptionInputValue {

        @Nested
        @DisplayName("3자리가 아닐 경우")
        class Size_check {

            @DisplayName("IllegalArgumentException를 반환한다 - 3자리 보다 큰 경우")
            @Test
            void 예외_테스트() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1234"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @DisplayName("IllegalArgumentException를 반환한다 - 3자리 보다 작은 경우")
            @Test
            void case1() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("12"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

        }

        @DisplayName("숫자가 아닌 값을 포함할 경우 IllegalArgumentException를 반환한다")
        @Test
        void case2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("a12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("0을 포함할 경우 IllegalArgumentException를 반환한다")
        @Test
        void case3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("120"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("중복된 값을 포함할 경우 IllegalArgumentException를 반환한다")
        @Test
        void case4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("122"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("볼카운트가")
    class ballCount {

        @DisplayName("3스트라이크")
        @Test
        void strike3() {
            assertRandomNumberInRangeTest(() -> {
                        runException("246");
                assertThat(output()).contains("3스트라이크");
            },
        2,4, 6
            );
        }

        @DisplayName("2스트라이크")
        @Test
        void strike2() {
            assertRandomNumberInRangeTest(() -> {
                        runException("246");
                assertThat(output()).contains("2스트라이크");
            },
        2,4, 7
            );
        }

        @DisplayName("1스트라이크")
        @Test
        void strike1() {
            assertRandomNumberInRangeTest(() -> {
                        runException("256");
                assertThat(output()).contains("1스트라이크");
            },
        2,4, 7
            );
        }

        @DisplayName("1볼 1스트라이크")
        @Test
        void ball1_strike1() {
            assertRandomNumberInRangeTest(() -> {
                        runException("265");
                        assertThat(output()).contains("1볼 1스트라이크");
                    },
                    2,4, 6
            );
        }

        @DisplayName("2볼 1스트라이크")
        @Test
        void ball2_strike1() {
            assertRandomNumberInRangeTest(() -> {
                        runException("426");
                        assertThat(output()).contains("2볼 1스트라이크");
                    },
                    2,4, 6
            );
        }

        @DisplayName("1볼")
        @Test
        void ball1() {
            assertRandomNumberInRangeTest(() -> {
                runException("365");
                assertThat(output()).contains("1볼");
            },
        2,4, 6
            );
        }

        @DisplayName("2볼")
        @Test
        void ball2() {
            assertRandomNumberInRangeTest(() -> {
                runException("364");
                assertThat(output()).contains("2볼");
            },
        2,4, 6
            );
        }

        @DisplayName("3볼")
        @Test
        void ball3() {
            assertRandomNumberInRangeTest(() -> {
                runException("624");
                assertThat(output()).contains("3볼");
            },
        2,4, 6
            );
        }

        @DisplayName("낫싱")
        @Test
        void nothing() {
            assertRandomNumberInRangeTest(() -> {
                runException("357");
                assertThat(output()).contains("낫싱");
            },
        2,4, 6
            );
        }
    }

    @DisplayName("입력한 값이 컴퓨터의 값과")
    @Nested
    class AnswerCheck {

        @DisplayName("일치하면 정답 메시지가 출력된다")
        @Test
        void rightAnswer() {
            assertRandomNumberInRangeTest(() -> {
                runException("246");
                assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }, 2, 4, 6);
        }

        @DisplayName("일치하지않으면 맞힐때까지 게임이 반복된다")
        @Test
        void wrongAnswer() {
            assertRandomNumberInRangeTest(() -> {
                runException("235", "245","246");
                assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }, 2, 4, 6);
        }
    }

    @DisplayName("정답을 맞힌 후")
    @Nested
    class EndGame {

        @DisplayName("1을 입력하면 다시 게임이 시작된다.")
        @Test
        void restartGame() {
            assertRandomNumberInRangeTest(() -> {
                runException("246", "1", "357");
                assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                        ,"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "3스트라이크");
            }, 2, 4, 6, 3,5,7);
        }

        @DisplayName("2을 입력하면 다시 게임이 종료된다.")
        @Test
        void closeGame() {
            assertRandomNumberInRangeTest(() -> {
                run("246", "2");
                assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                ,"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "게임을 완전히 종료합니다.");
            }, 2, 4, 6);
        }

        @DisplayName("1과 2 이외의 값 입력하면 제대로 된 입력을 요구한다..")
        @Test
        void wrongRestartInput() {
            assertRandomNumberInRangeTest(() -> {
                run("246", "3","3","3","2");
                assertThat(output()).contains("3스트라이크", "올바른 값을 입력해주세요","게임을 완전히 종료합니다.");
            }, 2, 4, 6);
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

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
