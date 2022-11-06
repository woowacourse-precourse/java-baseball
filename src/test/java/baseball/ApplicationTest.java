package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void evaluationToStringTest() {
        List<Integer> evaluation1 = Arrays.asList(0, 0);
        List<Integer> evaluation2 = Arrays.asList(1, 0);
        List<Integer> evaluation3 = Arrays.asList(0, 1);
        List<Integer> evaluation4 = Arrays.asList(2, 1);
        List<Integer> evaluation5 = Arrays.asList(0, 3);

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(evaluation1).isEqualTo("낫싱\n");
        softAssert.assertThat(evaluation2).isEqualTo("1볼\n");
        softAssert.assertThat(evaluation3).isEqualTo("1스트라이크\n");
        softAssert.assertThat(evaluation4).isEqualTo("2볼 1스트라이크\n");
        softAssert.assertThat(evaluation5).isEqualTo("3스트라이크\n");
    }

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

    @Test
    void stringToNumberListTest() {
        String numbersInString = "234";
        List<Integer> numberList = Arrays.asList(2, 3, 4);
        assertThat(Application.stringToNumberList(numbersInString)).isEqualTo(numberList);
    }

    @Test
    void evaluateGuessTest() {
        List<Integer> guess1 = Arrays.asList(1, 2, 3);
        List<Integer> answer1 = Arrays.asList(1, 2, 3);
        List<Integer> evaluation1 = Arrays.asList(0, 3);

        List<Integer> guess2 = Arrays.asList(1, 2, 3);
        List<Integer> answer2 = Arrays.asList(7, 8, 9);
        List<Integer> evaluation2 = Arrays.asList(0, 0);

        List<Integer> guess3 = Arrays.asList(1, 3, 2);
        List<Integer> answer3 = Arrays.asList(2, 8, 3);
        List<Integer> evaluation3 = Arrays.asList(2, 0);

        assertThat(Application.evaluateGuess(guess1, answer1)).isEqualTo(evaluation1);
        assertThat(Application.evaluateGuess(guess2, answer2)).isEqualTo(evaluation2);
        assertThat(Application.evaluateGuess(guess3, answer3)).isEqualTo(evaluation3);
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
