package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("Result 클래스 테스트")
    class ResultTest {

        @Test
        @DisplayName("0볼 0스트라이크 결과 테스트")
        void 결과테스트_낫싱() {
            Result result = new Result(0, 0);
            assertThat(result.toString()).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("1볼 0스트라이크 결과 테스트")
        void 결과테스트_1볼() {
            Result result = new Result(0, 1);
            assertThat(result.toString()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("0볼 1스트라이크 결과 테스트")
        void 결과테스트_1스트라이크() {
            Result result = new Result(1, 0);
            assertThat(result.toString()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("1볼 1스트라이크 결과 테스트")
        void 결과테스트_1볼_1스트라이크() {
            Result result = new Result(1, 1);
            assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
        }
    }

    @Nested
    @DisplayName("Computer 클래스 테스트")
    class ComputerTest {

        @Test
        @DisplayName("입력의 크기가 3보다 작다")
        void case1() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 2);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력의 크기가 3보다 크다")
        void case2() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 2, 3, 4);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력 값의 범위를 벗어난다")
        void case3() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(1, 3, 10);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복 값이 입력된다")
        void case4() {
            Computer computer = new Computer();
            List<Integer> answerList = List.of(2, 2, 2);

            assertThatThrownBy(() -> computer.compareAnswer(answerList))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("BaseballGame 클래스 테스트")
    class BaseballGameTest {

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {

            @Test
            @DisplayName("")
            void case1() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("")
            void case2() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("hello"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("")
            void case3() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @Nested
        @DisplayName("정상 동작 테스트")
        class NormalTest {

            @Test
            @DisplayName("1회 시도 후 종료")
            void case1() {
                assertRandomNumberInRangeTest(
                    () -> {
                        run("567", "2");
                        assertThat(output()).contains("3스트라이크", "게임 종료");
                    },
                    5, 6, 7
                );
            }

            @Test
            @DisplayName("3연속 연속 시도 후 종료")
            void case2() {
                assertRandomNumberInRangeTest(
                    () -> {
                        run("312", "123", "1", "645", "456", "1", "987", "789", "2");
                        assertThat(output()).contains("3볼", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3,4,5,6,7,8,9
                );
            }

            @Test
            @DisplayName("모든 케이스 출력")
            void case3() {
                assertRandomNumberInRangeTest(
                    () -> {
                        run("256", "216", "312", "134", "132", "156", "126", "123", "2");
                        assertThat(output()).contains(
                            "1볼",
                            "2볼",
                            "3볼",
                            "1볼 1스트라이크",
                            "2볼 1스트라이크",
                            "1스트라이크",
                            "2스트라이크",
                            "3스트라이크",
                            "게임 종료");
                    },
                    1, 2, 3
                );
            }
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
