package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberCollectionTest {
    private static final GameNumberCollection computerNumbers = new GameNumberCollection(List.of(1, 2, 3));
    private static final GameNumberCollection playerNumbers = new GameNumberCollection(List.of(3, 2, 1));


    @DisplayName("볼 개수를 반환한다")
    @Test
    void countBallsTest() {
        int actual = computerNumbers.countBalls(playerNumbers);
        assertThat(actual).isEqualTo(2);
    }


}
