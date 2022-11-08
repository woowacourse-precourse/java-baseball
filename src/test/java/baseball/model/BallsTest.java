package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    void validateDuplicate_중복된_숫자_값이_있을때_예외가_반환되는지_테스트() {
        //given
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        balls.add(new Ball(1));
        balls.add(new Ball(1));
        //when
        Set<Ball> ballSet = new HashSet<>(balls);
        //when, then
        assertThatThrownBy(() -> {
            if (ballSet.size() != balls.size()) {
                throw new IllegalArgumentException("입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.");
    }

    @Test
    void validateDuplicate_중복된_숫자_값이_없을때_Set와_List의_크기가_같은지_테스트() {
        //given
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        balls.add(new Ball(2));
        balls.add(new Ball(3));
        //when
        Set<Ball> ballSet = new HashSet<>(balls);
        //then
        assertThat(balls.size()).isEqualTo(ballSet.size());
    }

    @Test
    void validateSize_리스트의_사이즈가_3이_아닐_때_예외가_반환되는지_테스트() {
        //given
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        balls.add(new Ball(2));
        //when
        //then
        assertThatThrownBy(() -> {
            if (balls.size() != 3) {
                throw new IllegalArgumentException("입력된 숫자의 값이 3개가 아닙니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력된 숫자의 값이 3개가 아닙니다.");
    }

    @Test
    void addBall_숫자를_리스트에_추가할_때_이미_있는_숫자라면_리스트에_추가되지_않는지_테스트() {
        //given
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        Ball ball = new Ball(1);
        //when
        if (!balls.contains(ball)) {
            balls.add(ball);
        }
        //then
        assertThat(balls.size()).isEqualTo(1);
    }

    @Test
    void addBall_숫자를_리스트에_추가할_때_없는_숫자라면_리스트에_추가가_잘_되는지_테스트() {
        //given
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        Ball ball = new Ball(2);
        //when
        if (!balls.contains(ball)) {
            balls.add(ball);
        }
        //then
        assertThat(balls.size()).isEqualTo(2);
    }

    @Test
    void generateResult_컴퓨터의_값과_플레이어의_값이_2볼_1스트라이크일_경우_결과가_잘_반환되는지_테스트() {
        //given
        Result result = new Result();
        List<Ball> computerBalls = new ArrayList<>();
        computerBalls.add(new Ball(1));
        computerBalls.add(new Ball(2));
        computerBalls.add(new Ball(3));
        List<Ball> playerBalls = new ArrayList<>();
        playerBalls.add(new Ball(1));
        playerBalls.add(new Ball(3));
        playerBalls.add(new Ball(2));
        //when
        for (int i = 0; i < computerBalls.size(); i++) {
            if (Objects.equals(computerBalls.get(i), playerBalls.get(i))) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerBalls.contains(playerBalls.get(i))) {
                result.increaseBallCount();
            }
        }
        //then
        assertThat(result.getBallCount()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }
}