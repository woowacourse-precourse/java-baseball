package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static domain.Referee.*;
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
    void 유저의숫자_뽑아오기_테스트() {
        String input = "456";
        List<Integer> expect = Arrays.asList(4, 5, 6);
        List<Integer> result = User.getUserNumber(input);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 스트라이크_판단_테스트() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(1, 3, 5);
        String result = getResultStrike(computer, user) + STRIKE;

        assertThat(result).isEqualTo(1 + STRIKE);
    }

    @Test
    void 볼_판단_테스트() {
        List<Integer> computer = Arrays.asList(3, 1, 4);
        List<Integer> user = Arrays.asList(1, 3, 4);
        String result = getResultBall(computer, user) + BALL;

        assertThat(result).isEqualTo(2 + BALL);
    }

    @Test
    void threeStrikeTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(3, 4, 5);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(3 + STRIKE);
    }

    @Test
    void threeBallTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(5, 3, 4);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(3 + BALL);
    }

    @Test
    void nothingTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(7, 8, 9);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(NOTHING);
    }

    @Test
    void oneStrikeOneBallTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(3, 7, 4);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(1 + BALL + " " + 1 + STRIKE);
    }

    @Test
    void oneStrikeTwoBallTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(3, 5, 4);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(2 + BALL + " " + 1 + STRIKE);
    }

    @Test
    void twoBallTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(7, 3, 4);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(2 + BALL);
    }

    @Test
    void oneStrikeTest() {
        List<Integer> computer = Arrays.asList(3, 4, 5);
        List<Integer> user = Arrays.asList(7, 1, 5);
        String result = getJudgement(computer, user);

        assertThat(result).isEqualTo(1 + STRIKE);
    }

    @Test
    void 일부터_구까지_숫자말고_다른것입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력숫자_자릿수범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 반복되는_숫자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
