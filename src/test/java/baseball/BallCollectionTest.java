package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCollectionTest {
    @Test
    @DisplayName("컴퓨터 숫자 생성")
    public void SuccessInCreateComputerNumbers() {
        BallCollection computerNumbers = BallCollection.createComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(BallCollection.BALL_COUNT);
    }
}
