package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    @DisplayName("각 위치의 공이 몇개 같은지 반환한다.")
    void equalsTest() {
        Balls answer = Balls.convertNumberToBalls(List.of(1, 2, 3));
        Balls guess = Balls.convertNumberToBalls(List.of(4, 2, 3));

        int strike = answer.equalsExactly(guess);

        assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 위치의 공을 제외하고 몇개 포함하는지 반환한다.")
    void containTest() {
        Balls answer = Balls.convertNumberToBalls(List.of(1, 2, 3));
        Balls guess = Balls.convertNumberToBalls(List.of(3, 2, 5));

        int ball = answer.containsCountWithoutEqual(guess);

        assertThat(ball).isEqualTo(1);
    }

    @Test
    @DisplayName("공이 중복되면 예외를 발생한다")
    void uniqueBallTest() {
        assertThatThrownBy(() -> Balls.convertNumberToBalls(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자는 입력할 수 없습니다");
    }

    @Test
    @DisplayName("3자리 숫자를 입력하지 않으면 예외를 발생시킨다")
    void sizeTest() {
        assertThatThrownBy(() -> Balls.convertNumberToBalls(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자를 입력해주세요");
    }
}