package baseball.mytest;

import baseball.GameNumber;
import baseball.UserNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    @Test
    void 낫싱_테스트1() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        List<Integer> userNums = Arrays.asList(4, 5, 6);
        int strikes = gameNumber.getStrikes(userNums);
        int balls = gameNumber.getBalls(userNums);

        Assertions.assertThat(gameNumber.isNothing(strikes, balls)).isEqualTo(true);
    }

    @Test
    void 낫싱_테스트2() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        List<Integer> userNums = Arrays.asList(3, 4, 5);
        int strikes = gameNumber.getStrikes(userNums);
        int balls = gameNumber.getBalls(userNums);

        Assertions.assertThat(gameNumber.isNothing(strikes, balls)).isEqualTo(false);
    }

    @Test
    void 스트라이크_볼_테스트1() {
        List<Integer> gameNumbers = Arrays.asList(1, 2, 3);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        UserNumber userNumber = new UserNumber("345");
        List<Integer> userNums = userNumber.getUserNums();

        int strikes = gameNumber.getStrikes(userNums);
        int balls = gameNumber.getBalls(userNums);

        Assertions.assertThat(strikes).isEqualTo(0);
        Assertions.assertThat(balls).isEqualTo(1);
    }

    @Test
    void 스트라이크_볼_테스트2() {
        List<Integer> gameNumbers = Arrays.asList(3, 4, 5);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        UserNumber userNumber = new UserNumber("345");
        List<Integer> userNums = userNumber.getUserNums();

        int strikes = gameNumber.getStrikes(userNums);
        int balls = gameNumber.getBalls(userNums);

        Assertions.assertThat(strikes).isEqualTo(3);
        Assertions.assertThat(balls).isEqualTo(0);
    }

    @Test
    void 스트라이크_볼_테스트3() {
        List<Integer> gameNumbers = Arrays.asList(3, 5, 9);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        UserNumber userNumber = new UserNumber("345");
        List<Integer> userNums = userNumber.getUserNums();

        int strikes = gameNumber.getStrikes(userNums);
        int balls = gameNumber.getBalls(userNums);

        Assertions.assertThat(strikes).isEqualTo(1);
        Assertions.assertThat(balls).isEqualTo(1);
    }
}
