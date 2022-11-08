package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static baseball.Const.WRONG_INPUT;

public class BallsTest {

    @Test
    void 이미_있는_숫자와_겹치는지_확인하는_기능() {
        // given
        CollectionBalls balls = new CollectionBalls();
        balls.addBall(new Ball('1'));

        // then
        assertThat(balls.isDuplicate(new Ball('1'))).isTrue();
        assertThat(balls.isDuplicate(new Ball('2'))).isFalse();
    }

    @Test
    void 세자리_숫자를_만들어주는_기능() {
        // given
        CollectionBalls balls = new CollectionBalls();
        Set<Ball> duplicate = new HashSet<>();

        // when
        balls.generate();
        balls.getBallList().forEach(ball -> duplicate.add(ball));

        //then
        assertThat(balls.getBallList().size()).isEqualTo(3);
        assertThat(balls.getBallList().stream()
                .allMatch((ball) -> 1 <= ball.getNumber() && ball.getNumber() <= 9)).isTrue();
        assertThat(duplicate.size()).isEqualTo(3);
    }

    @Test
    void 입력을_Balls_클래스로_변경시켜주는_기능() {
        // given
        CollectionBalls balls = new CollectionBalls();

        // when
        balls.convertInputToBall("123");
        List<Ball> ballList = balls.getBallList();
        List<Integer> compareWithResult = List.of(1, 2, 3);
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            if (ballList.get(i).getNumber() != compareWithResult.get(i)) {
                result = false;
            }
        }

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 잘못된_입력이_들어왔을_때_예외를_반환하는_기능() {
        // given
        CollectionBalls balls = new CollectionBalls();

        // then
        assertThatThrownBy(() -> balls.convertInputToBall("12345"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_INPUT);
        assertThatThrownBy(() -> balls.convertInputToBall("01a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_INPUT);
    }
}
