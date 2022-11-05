package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameResultTest {

    @Test
    void calcStrikesTest() {
        BaseballGameResult gameResult = new BaseballGameResult();

        List<Integer> list1 = List.of(1, 4, 3);
        List<Integer> list2 = List.of(3, 4, 2);

        int result1 = gameResult.calcStrikes(list1, list2);

        assertThat(result1).isEqualTo(1);
    }

    @Test
    void calcBallsTest() {
        BaseballGameResult gameResult = new BaseballGameResult();

        List<Integer> list1 = List.of(1, 4, 3);
        List<Integer> list2 = List.of(3, 4, 1);

        int result1 = gameResult.calcBalls(list1, list2);

        assertThat(result1).isEqualTo(2);
    }

    @Test
    void getterTest() {
        List<Integer> list1 = List.of(1, 4, 3);
        List<Integer> list2 = List.of(3, 4, 1);

        BaseballGameResult gameResult = new BaseballGameResult(list1, list2);

        int numOfStrikes = gameResult.numOfStrikes();
        int numOfBalls = gameResult.numOfBalls();

        assertThat(numOfStrikes).isEqualTo(1);
        assertThat(numOfBalls).isEqualTo(2);
    }
}
