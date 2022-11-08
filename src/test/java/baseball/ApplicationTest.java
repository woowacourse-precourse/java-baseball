package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }

    @Nested
    class ComputerTest {
        Computer computer = new Computer();
        @Test
        void 난수_생성시_중복여부_검사() {
            List<Integer> randomNums = computer.randomNumbers();
            Set<Integer> setRandomNums = new HashSet<>(randomNums);

            assertEquals(randomNums.size(), setRandomNums.size());
        }

        @Test
        void 난수_범위가_1_9_인지_검사() {
            List<Integer> randomNums = computer.randomNumbers();
            assertThat(randomNums.stream().allMatch(randomNum -> randomNum >= 1 && randomNum <= 9)).isTrue();

        }
    }

    @Nested
    class UserTest {
        User user = new User();
        @Test
        void 숫자가_아닌_경우_에외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                user.inputNumbers("aaa");
            });
        }

        @Test
        void 입력값의_길이가_3이_아닌_경우_예외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                user.inputNumbers("12345");
            });

            assertThrows(IllegalArgumentException.class, () -> {
                user.inputNumbers("12");
            });
        }

        @Test
        void 중복된_숫자가_있을_경우_예외_발생() {
            assertThrows(IllegalArgumentException.class, () -> {
                user.inputNumbers("111");
            });
        }
    }

    @Nested
    class CompareNumberTest {
        CompareNumber compareNumber = new CompareNumber();
        @Test
        void 숫자를_못_맞출_시_false_반환() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            compareNumber.setComputer(computerNumber);

            assertFalse(compareNumber.gameRun(List.of(1, 3, 0)));
            assertFalse(compareNumber.gameRun(List.of(1, 4, 5)));
            assertFalse(compareNumber.gameRun(List.of(4, 5, 1)));
        }

        @Test
        void 모든_숫자를_맞출_시_true_반환() {
            List<Integer> computerNumber = List.of(1, 2, 3);
            compareNumber.setComputer(computerNumber);
            assertTrue(compareNumber.gameRun(List.of(1, 2, 3)));
        }
    }

    @Nested
    class RestartTest {
        BaseBallGame baseBallGame = new BaseBallGame();
        @Test
        void 게임_재시작시_입력값이_1_2가_아닐_경우_예외_발생() {
            String userInput = "5";
            assertThrows(IllegalArgumentException.class, () -> {
                baseBallGame.reStart(userInput);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

