package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    class NumberControllerTest {
        @Test
        void getUniqueThreeNumbersHaveValidLength() {
            final int length = 3;
            List<Integer> result = NumberController.getUniqueThreeNumbers();
            assertThat(result.size()).isEqualTo(length);
        }

        @Test
        void getUniqueThreeNumbersIsUnique() {
            int[] oneToNine = new int[10];
            Arrays.fill(oneToNine, 1);
            oneToNine[0] = 0;
            List<Integer> result = NumberController.getUniqueThreeNumbers();
            for (int num : result) {
                oneToNine[num]--;
                assertThat(oneToNine[num] == 0).isTrue();
            }
        }

        @Test
        void convertStringToNumbers() {
            String input = "123";
            List<Integer> expected = List.of(1,2,3);
            List<Integer> real = NumberController.convertStringToNumbers(input);
            assertThat(real).isEqualTo(expected);
            }


        @Test
        void strikesAndBallsCase1() {
            List<Integer> input = List.of(1, 2, 3);
            List<Integer> computers = List.of(3, 4, 5);
            List<Integer> expected = List.of(0, 1);
            List<Integer> real = NumberController.getStrikesAndBalls(input, computers);
            assertThat(real).isEqualTo(expected);
        }

        @Test
        void strikesAndBallsCase2() {
            List<Integer> input = List.of(2, 7, 3);
            List<Integer> computers = List.of(2, 7, 3);
            List<Integer> expected = List.of(3, 0);
            List<Integer> real = NumberController.getStrikesAndBalls(input, computers);
            assertThat(real).isEqualTo(expected);
        }

        @Test
        void strikesAndBallsCase3() {
            List<Integer> input = List.of(1, 5, 2);
            List<Integer> computers = List.of(5, 1, 2);
            List<Integer> expected = List.of(1, 2);
            List<Integer> real = NumberController.getStrikesAndBalls(input, computers);
            assertThat(real).isEqualTo(expected);
        }
    }


    @Nested
    class InputControllerTest {

        @Test()
        void checkThreeNumNotInt() {
            String input = "99l";
            assertThatThrownBy(() -> InputController.validateThreeNum(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void checkThreeNumNoInput() {
            String input = "";
            assertThatThrownBy(() -> InputController.validateThreeNum(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void checkThreeNumNotInRange() {
            String input = "301";
            assertThatThrownBy(() -> InputController.validateThreeNum(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void checkThreeNumLengthOver() {
            String input = "1234";
            assertThatThrownBy(() -> InputController.validateThreeNum(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void checkThreeNumDuplicate() {
            String input = "221";
            assertThatThrownBy(() -> InputController.validateThreeNum(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class InfoPrinterTest {
        @Test
        void printStrikesAndBallsCase1() {
            List<Integer> input = List.of(2,1);
            String result = "1볼 2스트라이크";

            InfoPrinter.printStrikesAndBalls(input);
            assertThat(output()).isEqualTo(result);
        }

        @Test
        void printStrikesAndBallsCase2() {
            List<Integer> input = List.of(0,2);
            String result = "2볼";

            InfoPrinter.printStrikesAndBalls(input);
            assertThat(output()).isEqualTo(result);
        }

        @Test
        void printStrikesAndBallsCase3() {
            List<Integer> input = List.of(3,0);
            String result = "3스트라이크";

            InfoPrinter.printStrikesAndBalls(input);
            assertThat(output()).isEqualTo(result);
        }

        @Test
        void printStrikesAndBallsCase4() {
            List<Integer> input = List.of(0,0);
            String result = "낫싱";

            InfoPrinter.printStrikesAndBalls(input);
            assertThat(output()).isEqualTo(result);
        }

        @Test
        void validateFlagNumNotInt() {
            String input = "dsf";
            assertThatThrownBy(() -> InputController.validateFlagNum(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void validateFlagNumNotOneAndTwo() {
            String input = "12";
            assertThatThrownBy(() -> InputController.validateFlagNum(input)).isInstanceOf(IllegalArgumentException.class);
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
