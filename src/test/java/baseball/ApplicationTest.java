package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void makeAnswerTest() {
        List<Integer> answer = Application.makeAnswer();
        Set<Integer> numbersInAnswer = new HashSet<>(answer);
        assertThat(numbersInAnswer).hasSize(3)
                .doesNotContain(0);
    }

    @Test
    void subArrayTest() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] subArray = Application.subArray(arr, 1, 3);
        assertThat(subArray).isEqualTo(new int[]{2, 3, 4});
    }

    @Test
    void isValidNumbersForGameTest() {
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(Application.isValidNumbersForGame("")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("34a")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("23")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("151")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("204")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("123")).isTrue();
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
