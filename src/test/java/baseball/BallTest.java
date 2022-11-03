package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.utils.Ball;

class BallTest {
	Ball ball = Ball.getInstance();
	List<String> range = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

	@Test
	void 랜덤_공번호_생성() {
		assertTrue(range.contains(ball.createRandomBall()));
	}

	@Test
	void 컴퓨터_공번호_3자리_확인() {
		assertThat(ball.makeComputerBalls().size()).isEqualTo(3);
	}

	@Test
	void 컴퓨터_공번호_중복숫자_판별(){
		List<String> balls = ball.makeComputerBalls();
		assertThat(new HashSet<>(balls).size()).isEqualTo(balls.size());
	}
}