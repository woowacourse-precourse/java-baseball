package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRunnerTest extends NsTest {

    @Nested
    @DisplayName("run 메소드는")
    class RunMethodTest {

        @Nested
        @DisplayName("플레이어 입력이 모두 유효한 경우")
        class RunMethodValidPlayerInput {

            @Test
            @DisplayName("만약 플레이어가 정답을 입력하면 그에 맞는 힌트 로그를 출력한다.")
            void all_hint_log_test() {
                assertRandomNumberInRangeTest(
                        () -> {
                            run("456", "145", "125", "345", "315", "312", "135", "132", "123", "2");
                            assertThat(output()).contains("낫싱",
                                    "1스트라이크",
                                    "2스트라이크",
                                    "1볼",
                                    "2볼",
                                    "3볼",
                                    "1볼 1스트라이크",
                                    "2볼 1스트라이크",
                                    "게임 종료");
                        }, 1, 2, 3
                );
            }

            @Test
            @DisplayName("만약 3스트라이크를 맞추고 게임 종료를 선택하면 그에 맞는 로그를 출력한다.")
            void exit_test() {
                assertRandomNumberInRangeTest(
                        () -> {
                            run("123", "2");
                            assertThat(output()).contains("3스트라이크", "게임 종료");
                            assertThat(output()).doesNotContain("볼");
                        }, 1, 2, 3
                );
            }

            @Test
            @DisplayName("만약 3스트라이크를 맞추고 게임 시작을 선택하면 그에 맞는 로그를 출력한다.")
            void restart_exit_test() {
                assertRandomNumberInRangeTest(
                        () -> {
                            run("123", "1", "132", "123", "2");
                            assertThat(output()).contains("3스트라이크", "게임 종료", "2볼 1스트라이크");
                        }, 1, 2, 3, 1, 2, 3
                );
            }
        }

        @Nested
        @DisplayName("플레이어 입력이 유효하지 않은 경우")
        class RunMethodWrongPlayerInput {

            @ParameterizedTest
            @ValueSource(
                    strings = {
                        "111",
                        "12",
                        "1234",
                        "a12",
                        "1 2"
                    }
            )
            @DisplayName("만약 플레이어가 정답을 입력할 때라면 IllegalArgumentException 예외가 발생한다.")
            void player_answer_input_exception_test(String wrongPlayerInput) {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(wrongPlayerInput))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "a",
                    "+",
                    "0",
                    "3",
                    "@",
                    "12"
                }
        )
        @DisplayName("만약 플레이어가 게임 재시작 유무를 결정할 때라면 IllegalArgumentException 예외가 발생한다.")
        void player_command_input_exception_test(String wrongPlayerInput) {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("123", wrongPlayerInput))
                            .isInstanceOf(IllegalArgumentException.class), 1, 2, 3);
        }
    }

    @Override
    protected void runMain() {
        GameRunner.run();
    }
}