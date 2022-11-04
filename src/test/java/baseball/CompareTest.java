package baseball;

import baseball.game.Comparator;
import baseball.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CompareTest {
    @Test
    void compareNothing() {
        List<Integer> answer = Arrays.asList(6, 4, 5);
        List<Integer> nothing = Arrays.asList(1, 2, 3);

        Comparator comparator = Comparator.getInstance().compare(answer, nothing);

        assertThat(comparator.getStrike()).isEqualTo(0);
        assertThat(comparator.getBall()).isEqualTo(0);

        assertThat(Game.printResult(comparator)).contains("낫싱");
    }

    @Test
    void compareBall() {
        List<Integer> answer = Arrays.asList(6, 4, 5);
        List<Integer> nothing = Arrays.asList(4, 6, 3);
        String result;

        Comparator comparator = Comparator.getInstance().compare(answer, nothing);

        assertThat(comparator.getStrike()).isEqualTo(0);
        assertThat(comparator.getBall()).isEqualTo(2);

        result = Game.printResult(comparator);

        assertThat(result).contains("볼");
        assertThat(result).doesNotContain("스트라이크");
    }

    @Test
    void compareStrike() {
        List<Integer> answer = Arrays.asList(6, 4, 5);
        List<Integer> nothing = Arrays.asList(6, 4, 1);
        String result;

        Comparator comparator = Comparator.getInstance().compare(answer, nothing);

        assertThat(comparator.getStrike()).isEqualTo(2);
        assertThat(comparator.getBall()).isEqualTo(0);

        result = Game.printResult(comparator);

        assertThat(result).contains("2스트라이크");
        assertThat(result).doesNotContain("볼");
    }

    @Test
    void compareStrikeAndBall() {
        List<Integer> answer = Arrays.asList(6, 4, 5);
        List<Integer> nothing = Arrays.asList(5, 4, 1);

        Comparator comparator = Comparator.getInstance().compare(answer, nothing);

        assertThat(comparator.getStrike()).isEqualTo(1);
        assertThat(comparator.getBall()).isEqualTo(1);

        assertThat(Game.printResult(comparator)).contains("1볼 1스트라이크");
    }
}
