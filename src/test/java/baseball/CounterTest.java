package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterTest {
    @Test
    public void getStrikeCount_메서드로_스트라이크_개수를_반환() {
        BaseballGameNumber computerNumber = new BaseballGameNumber(List.of(3, 6, 9));
        BaseballGameNumber expectedNumber = new BaseballGameNumber(List.of(3, 6, 8));

        int strikeCount = Counter.getStrikeCount(computerNumber, expectedNumber);

        Assertions.assertThat(strikeCount).isEqualTo(2);
    }
}
