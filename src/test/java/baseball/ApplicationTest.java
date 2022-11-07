package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    public void 볼_개수_측정_테스트() {
        // Given
        Integer[] realAns = {1, 2, 3};
        Integer[] case1 = {1, 3, 2};
        Integer[] case2 = {4, 1, 2};

        // When
        int ballCase1 = Application.countBall(realAns, case1, 1);
        int ballCase2 = Application.countBall(realAns, case2, 0);

        // Then
        assertThat(ballCase1).isEqualTo(2);
        assertThat(ballCase2).isEqualTo(2);

    }

    @Test
    public void 스트라이크_개수_측정_테스트() {
        // Given
        Integer[] realAns = {1, 2, 3};
        Integer[] case1 = {1, 2, 4};
        Integer[] case2 = {1, 3, 8};
        Integer[] case3 = {9, 8, 7};

        // When
        int cnt1 = Application.countStrike(realAns, realAns);
        int cnt2 = Application.countStrike(realAns, case1);
        int cnt3 = Application.countStrike(realAns, case2);
        int cnt4 = Application.countStrike(realAns, case3);

        // Then
        assertThat(cnt1).isEqualTo(3);
        assertThat(cnt2).isEqualTo(2);
        assertThat(cnt3).isEqualTo(1);
        assertThat(cnt4).isEqualTo(0);
    }

    @Test
    public void 입력값_변환기_동작_테스트() {
        // Given
        String userInput = "123";
        String userInput1 = "1234";
        String userInput2 = "abc";
        String userInput3 = "12";

        // When
        Integer[] userAnswerArray = Application.userInputToIntegerArray(userInput);

        // Then
        assertThat(userAnswerArray).isEqualTo(new Integer[]{1, 2, 3});

        assertThatThrownBy(() -> Application.userInputToIntegerArray(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.userInputToIntegerArray(userInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.userInputToIntegerArray(userInput3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 정답생성기_테스트() {
        // Given
        Integer[] answer = Application.generateAnswer();

        // When
        Set<Integer> answerSet = new HashSet<>(Arrays.asList(answer));

        // Then
        // 길이가 3
        assertThat(answer.length).isEqualTo(3);
        // 겹치는 숫자가 없음
        assertThat(answerSet.size()).isEqualTo(3);
        // 모든 숫자는 1~9 사이의 숫자임.
        for (int number : answer) {
            assertThat(number).isGreaterThan(0);
            assertThat(number).isLessThan(10);
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
