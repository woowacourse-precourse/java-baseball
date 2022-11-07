package baseball;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}
