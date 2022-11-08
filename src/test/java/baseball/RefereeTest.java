package baseball;

import domain.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.Referee.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    void 유저의숫자_뽑아오기_테스트() {
        String input = "456";
        List<Integer> expect = Arrays.asList(4, 5, 6);
        List<Integer> result = User.getNumber(input);
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
}
