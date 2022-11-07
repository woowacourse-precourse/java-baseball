package baseball.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    @DisplayName("각 위치의 공이 몇개 같은지 반환한다.")
    void equalsTest() {
        Balls answer = Balls.convertNumberToBalls(List.of(1, 2, 3));
        Balls guess = Balls.convertNumberToBalls(List.of(4, 2, 3));

        int strike = answer.equalsExactly(guess);

        Assertions.assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 위치의 공을 제외하고 몇개 포함하는지 반환한다.")
    void containTest() {
        Balls answer = Balls.convertNumberToBalls(List.of(1, 2, 3));
        Balls guess = Balls.convertNumberToBalls(List.of(3, 2, 5));

        int ball = answer.containsCountWithoutEqual(guess);

        Assertions.assertThat(ball).isEqualTo(1);
    }

}