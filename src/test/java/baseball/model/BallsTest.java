package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @Test
    void 같은_숫자_같은_위치_스트라이크_확인하기() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, 0));
        balls.add(new Ball(3, 1));
        balls.add(new Ball(5, 2));


        Balls computer = new Balls(balls);


        assertThat(computer.isStrike(new Ball(3, 1))).isTrue();
        assertThat(computer.isStrike(new Ball(3, 2))).isFalse();
    }

    @Test
    void 같은_숫자_다른_위치_볼_확인하기() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, 0));
        balls.add(new Ball(3, 1));
        balls.add(new Ball(5, 2));


        Balls computer = new Balls(balls);


        assertThat(computer.isBall(new Ball(3, 0))).isTrue();
        assertThat(computer.isBall(new Ball(1, 0))).isFalse();
    }

    @Test
    void 존재하지_않는_숫자_아웃_확인하기() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, 0));
        balls.add(new Ball(3, 1));
        balls.add(new Ball(5, 2));


        Balls computer = new Balls(balls);


        assertThat(computer.isOut(new Ball(2, 1))).isTrue();
        assertThat(computer.isOut(new Ball(3, 1))).isFalse();
    }

    @Test
    void 사용자_공_3개_판정() {
        List<Ball> computerBalls = new ArrayList<>();

        computerBalls.add(new Ball(1, 0));
        computerBalls.add(new Ball(3, 1));
        computerBalls.add(new Ball(5, 2));

        List<Ball> userBalls = new ArrayList<>();

        userBalls.add(new Ball(2, 2));
        userBalls.add(new Ball(3, 1));
        userBalls.add(new Ball(5, 0));

        Balls computer = new Balls(computerBalls);
        Balls user = new Balls(userBalls);

        Result result = new Result(1, 1, 1);
        assertThat(computer.getResult(user)).isEqualTo(result);
    }

    @Test
    void Balls_중복_숫자_존재할_경우_예외_던지기() {
        List<Ball> ballList = List.of(
                new Ball(1, 0)
                , new Ball(1, 1)
                , new Ball(2, 2)
        );

        assertThatThrownBy(() -> {
            Balls user = new Balls(ballList);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
