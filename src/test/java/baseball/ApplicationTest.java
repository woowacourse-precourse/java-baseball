package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.*;

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
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class compareUserInputAndComputerSelect_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                int userInput = 425;
                Application.computerDigitValue = List.of(5, 1, 2);
                List<Integer> result = List.of(1, 1, 1);
                assertThat(result).isEqualTo(Application.compareUserInputAndComputerSelect(userInput));
            }
        }
    }

    @Nested
    class getScore_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                Application.computerDigitValue = List.of(5, 2, 4);
                int result = Application.BALL;
                assertThat(result).isEqualTo(Application.getScore(2, Application.DIGIT_1));
            }

            @Test
            void case2() {
                Application.computerDigitValue = List.of(5, 2, 4);
                int result = Application.STRIKE;
                assertThat(result).isEqualTo(Application.getScore(5, Application.DIGIT_1));
            }

            @Test
            void case3() {
                Application.computerDigitValue = List.of(5, 2, 4);
                int result = Application.NOTHING;
                assertThat(result).isEqualTo(Application.getScore(1, Application.DIGIT_100));
            }
        }
    }

    @Nested
    class disassembleDigitNumber_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                //425가 입력됐을 때 5, 2, 4인 리스트가 반환
                List<Integer> result = List.of(5, 2, 4);
                assertThat(result).isEqualTo(Application.disassembleDigitNumber(425));
            }
        }
    }

    @Nested
    class isValidData_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                assertThat(true).isEqualTo(Application.isValidData(425));
            }
        }

        @Nested
        class fail_case {
            @Test
            void case1() {
                assertThatThrownBy(() -> Application.isValidData(1234))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            void case2() {
                assertThatThrownBy(() -> Application.isValidData(1))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            void case3() {
                assertThatThrownBy(() -> Application.isValidData(102))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    class getResultString_Test {
        @Nested
        class success_case {
            @Test
            void case1() {
                List<Integer> result = List.of(1, 1, 1);
                assertThat("1볼 1스트라이크").isEqualTo(Application.getResultString(result));

            }

            @Test
            void case2() {
                List<Integer> result = List.of(2, 0, 1);
                assertThat("2스트라이크").isEqualTo(Application.getResultString(result));
            }

            @Test
            void case3() {
                List<Integer> result = List.of(0, 0, 3);
                assertThat("낫싱").isEqualTo(Application.getResultString(result));
            }

            @Test
            void case4() {
                List<Integer> result = List.of(0, 3, 0);
                assertThat("3볼").isEqualTo(Application.getResultString(result));
            }
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
