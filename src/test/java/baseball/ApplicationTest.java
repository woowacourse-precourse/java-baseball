package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void generateThreeDigitNumber() {
        Application.generateThreeDigitNumber();
        int[] threeDigitNumber = Application.randomNumber;
        for (int i = 0; i < 1000; i++) {
            assertThat(threeDigitNumber[0]).isGreaterThan(0).isLessThan(10);
            assertThat(threeDigitNumber[1]).isGreaterThan(0).isLessThan(10);
            assertThat(threeDigitNumber[2]).isGreaterThan(0).isLessThan(10);
        }
    }


    @Test
    void userInputValidation() {
        String[] inputs = {"12.3", "abc", "1ab", "1232"};
        for (String input : inputs) {
            assertThatThrownBy(() -> Application.userInputValidation(input)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Test
    void askNewGameInputValidation1() {
        String input = "3";
        assertThatThrownBy(() -> Application.askNewGame(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void userNumberRangeCheck() {
        int input = Integer.parseInt("100");
        assertThatThrownBy(() -> {
            Application.userNumberRangeCheck(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
