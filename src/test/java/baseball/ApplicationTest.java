package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

class ApplicationTest extends NsTest {
    @Test
    void evaluationToString_메서드로_추측_결과를_문자열로_반환() {
        List<Integer> evaluation1 = Arrays.asList(0, 0);
        List<Integer> evaluation2 = Arrays.asList(1, 0);
        List<Integer> evaluation3 = Arrays.asList(0, 1);
        List<Integer> evaluation4 = Arrays.asList(2, 1);
        List<Integer> evaluation5 = Arrays.asList(0, 3);

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(Application.evaluationToString(evaluation1)).isEqualTo("낫싱");
        softAssert.assertThat(Application.evaluationToString(evaluation2)).isEqualTo("1볼");
        softAssert.assertThat(Application.evaluationToString(evaluation3)).isEqualTo("1스트라이크");
        softAssert.assertThat(Application.evaluationToString(evaluation4)).isEqualTo("2볼 1스트라이크");
        softAssert.assertThat(Application.evaluationToString(evaluation5)).isEqualTo("3스트라이크");

        softAssert.assertAll();
    }

    @Test
    void makeAnswer_메서드로_1부터_9_안의_서로_다른_세자리_숫자_생성() {
        List<Integer> answer = Application.makeAnswer();
        Set<Integer> numbersInAnswer = new HashSet<>(answer);
        assertThat(numbersInAnswer).hasSize(3)
                .doesNotContain(0);
    }

    @Test
    void isValidNumbersForGame_메서드로_1부터_9_안의_서로_다른_세자리_숫자인지_검사() {
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(Application.isValidNumbersForGame("")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("34a")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("23")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("151")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("204")).isFalse();
        softAssert.assertThat(Application.isValidNumbersForGame("123")).isTrue();

        softAssert.assertAll();
    }

    @Test
    void stringToNumberList_메서드로_문자열_입력을_Integer_List로_변환() {
        String numbersInString = "234";
        List<Integer> numberList = Arrays.asList(2, 3, 4);
        assertThat(Application.stringToNumberList(numbersInString)).isEqualTo(numberList);
    }

    @Test
    void evaluateGuess_메서드로_볼과_스트라이크의_개수를_List로_반환() {
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

//     Randoms.pickNumberInRange 에서 중복된 숫자를 줄 때 테스트
    @Test
    void makeAnswer_메서드_안에서_중복된_숫자가_뽑힐_시_다른_숫자가_나올_때까지_pickNumberInRange_메서드_호출() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 1, 3, 3, 5);
        List<Integer> answer = Application.makeAnswer();
        assertThat(answer).isEqualTo(List.of(1, 3, 5));
        mock.close();
    }

    @Test
    void 잘못된_게임_진행_옵션_입력에_대한_예외_테스트() {
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
        assertThatThrownBy(() -> {
            run("135", "3");
        }).isInstanceOf(IllegalArgumentException.class);
        mock.close();
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
