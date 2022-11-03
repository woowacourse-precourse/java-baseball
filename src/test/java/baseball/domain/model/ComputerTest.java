package baseball.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void BallCount_판정_스트라이크() {
		List<String> computerBalls = List.of("3", "5", "7");
		Computer computer = new Computer(computerBalls);
		assertThat(computer.compareWithUserBall("3", 0)).isEqualTo(BallCount.STRIKE);
		assertThat(computer.compareWithUserBall("5", 1)).isEqualTo(BallCount.STRIKE);
		assertThat(computer.compareWithUserBall("7", 2)).isEqualTo(BallCount.STRIKE);
	}

	@Test
	void BallCount_판정_볼() {
		List<String> computerBalls = List.of("3", "5", "7");
		Computer computer = new Computer(computerBalls);
		assertThat(computer.compareWithUserBall("3", 1)).isEqualTo(BallCount.BALL);
		assertThat(computer.compareWithUserBall("5", 2)).isEqualTo(BallCount.BALL);
		assertThat(computer.compareWithUserBall("7", 0)).isEqualTo(BallCount.BALL);
	}

	@Test
	void BallCount_판정_아웃() {
		List<String> computerBalls = List.of("3", "5", "7");
		Computer computer = new Computer(computerBalls);
		assertThat(computer.compareWithUserBall("4", 1)).isEqualTo(BallCount.OUT);
		assertThat(computer.compareWithUserBall("9", 2)).isEqualTo(BallCount.OUT);
		assertThat(computer.compareWithUserBall("6", 0)).isEqualTo(BallCount.OUT);
	}

}