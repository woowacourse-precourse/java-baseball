package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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

    @Test
    void numberDuplicateCheckTest() {
        List<List<Integer>> checkList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            checkList.add(Start.startGame());
        }

        for (int j = 0; j < checkList.size(); j++) {
            Integer zeroIndex = checkList.get(j).get(0);
            assertThat(zeroIndex).isNotEqualTo(checkList.get(j).get(1));
            assertThat(zeroIndex).isNotEqualTo(checkList.get(j).get(2));
        }
    }

    @Test
    void exceptionTest() {
        ExceptionCheck exceptionCheck = new ExceptionCheck();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationLength("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationDuplicate("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationInputZero("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationCharDetect("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void numberComparisonTest() {
        List<Integer> correctAnswer = List.of(1, 2, 3);
        List<Integer> slicedInput = List.of(3, 2, 1);
        NumberComparison comparison = new NumberComparison();
        int strikeCount = comparison.checkStrike(correctAnswer, slicedInput);
        int ballCount = comparison.checkBall(correctAnswer, slicedInput);
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
