package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
    @Nested
    class ComputerTest {
        Computer computer = new Computer();

        @DisplayName("숫자 범위 테스트")
        @Test
        void rangeTest() {
            computer.generateNumber();
            List<Integer> testList = computer.getNumbers();
            boolean result = testList.stream().allMatch(num -> (num >= 1 && num <= 9));

            assertThat(result).isTrue();
        }

        @DisplayName("숫자 길이 테스트")
        @Test
        void lengthTest() {
            computer.generateNumber();
            List<Integer> testList = computer.getNumbers();
            int result = testList.size();

            assertThat(result).isEqualTo(3);
        }
        @DisplayName("숫자 중복 테스트")
        @Test
        void repeatTest() {
            computer.generateNumber();
            List<Integer> testList = computer.getNumbers();
            assertThat(testList).doesNotHaveDuplicates();
        }
    }

    @DisplayName("예외 처리 상세 테스트")
    @Nested
    class ExceptionTest {
        @DisplayName("숫자 외의 입력값 예외 처리 테스트 1")
        @Test
        void case1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("asd"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("숫자만 입력해주세요.")
            );
        }

        @DisplayName("숫자 외의 입력값 예외 처리 테스트 2")
        @Test
        void case2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12~"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("숫자만 입력해주세요.")
            );
        }

        @DisplayName("숫자 범위 예외 처리 테스트 1")
        @Test
        void case3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("104"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1에서 9사이의 숫자만 입력해주세요.")
            );
        }

        @DisplayName("숫자 범위 예외 처리 테스트 2")
        @Test
        void case4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1에서 9사이의 숫자만 입력해주세요.")
            );
        }

        @DisplayName("숫자 길이 예외 처리 테스트")
        @Test
        void case5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("올바른 길이의 숫자를 입력해주세요.")
            );
        }

        @DisplayName("숫자 중복 예외 처리 테스트")
        @Test
        void case6() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("933"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("서로 다른 숫자를 입력해주세요.")
            );
        }
    }

    @DisplayName("숫자 비교 기능 테스트")
    @Nested
    class CompareTest {
        Computer computer = new Computer();

        @DisplayName("스트라이크 판정 테스트")
        @Test
        void strikeTest() {
            computer.generateNumber();
            List<Integer> testList = computer.getNumbers();
            String numberToCompare = testList.toString().replaceAll("[^1-9]", "");
            Result result = computer.compareNumber(numberToCompare);

            assertThat(result.getStrikeCount()).isEqualTo(3);
        }

        @DisplayName("볼 판정 테스트")
        @Test
        void ballTest() {
            computer.generateNumber();
            List<Integer> testList = computer.getNumbers();
            List<Integer> newList = new ArrayList<>();
            newList.addAll(testList.subList(1,3));
            newList.add(testList.get(0));
            String numberToCompare = newList.toString().replaceAll("[^1-9]", "");

            Result result = computer.compareNumber(numberToCompare);
            assertThat(result.getBallCount()).isEqualTo(3);
        }

        @DisplayName("결과 출력 테스트 1")
        @Test
        void printTest1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "853", "183", "153", "135", "2");
                        assertThat(output()).contains("낫싱", "2볼", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크","3개의 숫자를 모두 맟히셨습니다! ","게임 종료");
                    },
                    1, 3, 5
            );
        }

        @DisplayName("결과 출력 테스트 2")
        @Test
        void printTest2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("248", "213", "258", "581", "587", "589", "2");
                        assertThat(output()).contains("1볼", "낫싱", "2볼", "2스트라이크", "2스트라이크", "3스트라이크", "3개의 숫자를 모두 맟히셨습니다! ", "게임 종료");
                    },
                    5, 8, 9
            );
        }
    }

    @DisplayName("게임 종료 후 사용자 입력 예외 처리 테스트")
    @Nested
    class ChoiceTest {
        @DisplayName("숫자 외의 입력값 예외 처리 테스트")
        @Test
        void case1() {
            assertRandomNumberInRangeTest(() ->
                            assertThatThrownBy(() ->
                                    run("123", "asd"))
                                    .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessageContaining("숫자만 입력해주세요."),
                    1, 2, 3
            );
        }

        @DisplayName("1 또는 2가 아닌 입력값 예외 처리 테스트")
        @Test
        void case2() {
            assertRandomNumberInRangeTest(() ->
                            assertThatThrownBy(() ->
                                    run("123", "3"))
                                    .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessageContaining("1 또는 2를 입력해주세요."),
                    1, 2, 3
            );
        }
    }

}
