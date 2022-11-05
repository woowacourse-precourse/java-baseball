package baseball.service;

import baseball.Ball;
import baseball.Result;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeServiceTest {

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
        for (int i = 0; i < playerBalls.size(); i++) {
            Ball computerBall = computerBalls.get(i);
            Ball playerBall = playerBalls.get(i);

            if (computerBall.equals(playerBall)) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerBalls.contains(playerBall)) {
                result.increaseBallCount();
            }
        }
        //then
        assertThat(result.getBallCount())
                .isEqualTo(2);
        assertThat(result.getStrikeCount())
                .isEqualTo(1);
    }
}