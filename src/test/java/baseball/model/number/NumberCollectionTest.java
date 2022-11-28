package baseball.model.number;

import baseball.model.number.NumberCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberCollectionTest {
    private static final NumberCollection computerNumbers = new NumberCollection(List.of(1, 2, 3));
    private static final NumberCollection playerNumbers = new NumberCollection(List.of(3, 2, 1));


    @DisplayName("스트라이크 개수를 반환한다")
    @Test
    void countStrikesTest() {
        int actual = computerNumbers.countStrikes(playerNumbers);
        assertThat(actual).isEqualTo(1);
    }


    @DisplayName("볼 개수를 반환한다")
    @Test
    void countBallsTest() {
        int actual = computerNumbers.countBalls(playerNumbers);
        assertThat(actual).isEqualTo(2);
    }


}
