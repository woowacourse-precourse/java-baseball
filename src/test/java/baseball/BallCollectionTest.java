package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallCollectionTest {
    @Test
    @DisplayName("컴퓨터 숫자 생성")
    public void SuccessInCreateComputerNumbers() {
        BallCollection computerNumbers = BallCollection.createComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(BallCollection.BALL_COUNT);
    }

    @Test
    @DisplayName("세자리 숫자가 아닌경우 예외처리")
    public void FailToCreateBallCollectionIfSizeIsNotBALL_COUNT() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        assertThatThrownBy(() -> new BallCollection(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 숫자가 있는 경우 예외처리")
    public void FailToCreateBallCollectionIfThereAreDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(2, 1, 2);

        assertThatThrownBy(() -> new BallCollection(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복없는 3자리 숫자인 정상입력")
    public void SuccessInCreateBallCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        BallCollection balls = new BallCollection(numbers);

        assertThat(balls).isInstanceOf(BallCollection.class);
        assertThat(balls.size()).isEqualTo(BallCollection.BALL_COUNT);
    }
}
