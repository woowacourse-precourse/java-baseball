package controller;

import static baseball.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.controller.BaseballGameController;
import baseball.domain.Balls;
import baseball.domain.BaseballGameResult;

public class BaseballGameControllerTest {

	@Test
	@DisplayName("3스트라이크인 경우를 테스트")
	void judgeThreeStrike() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(1, 2, 3));
		Balls ballsPickedByUser = new Balls(Arrays.asList(1, 2, 3));

		// when
		BaseballGameResult result = BaseballGameController.judge(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(result.getNumberOfStrike()).isEqualTo(3);
		assertThat(result.getNumberOfBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("3볼인 경우를 테스트")
	void judgeThreeBall() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(1, 2, 3));
		Balls ballsPickedByUser = new Balls(Arrays.asList(3, 1, 2));

		// when
		BaseballGameResult result = BaseballGameController.judge(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(result.getNumberOfStrike()).isEqualTo(0);
		assertThat(result.getNumberOfBall()).isEqualTo(3);
	}

	@Test
	@DisplayName("1스트라이크 1볼인 경우를 테스트")
	void judgeOneStrikeOneBall() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(1, 2, 3));
		Balls ballsPickedByUser = new Balls(Arrays.asList(1, 3, 5));

		// when
		BaseballGameResult result = BaseballGameController.judge(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(result.getNumberOfStrike()).isEqualTo(1);
		assertThat(result.getNumberOfBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("0스트라이크 0볼인 경우를 테스트")
	void judgeZeroStrikeZeroBall() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(1, 2, 3));
		Balls ballsPickedByUser = new Balls(Arrays.asList(9, 8, 7));

		// when
		BaseballGameResult result = BaseballGameController.judge(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(result.getNumberOfStrike()).isEqualTo(0);
		assertThat(result.getNumberOfBall()).isEqualTo(0);
	}

	@Test
	@DisplayName("컴퓨터가 공을 뽑는 기능 테스트")
	void computerPickBalls() {
		// given

		// when
		Balls pickedBalls = BaseballGameController.pickComputerBalls();

		// then
		assertThat(pickedBalls.getPickedBalls().size()).isEqualTo(NUMBER_OF_BALLS_FOR_BASEBALL_GAME);
	}

	@Test
	@DisplayName("사용자가 공을 뽑는 기능 테스트")
	void userPickBalls() {
		// given
		String input = "123";
		InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);

		// when
		Balls pickedBalls = BaseballGameController.pickUserBalls();

		// then
		assertThat(pickedBalls.getPickedBalls().size()).isEqualTo(NUMBER_OF_BALLS_FOR_BASEBALL_GAME);
		assertThat(pickedBalls.getPickedBalls()).isEqualTo(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("스트라이크를 제대로 판단하는지 테스트")
	void judgeStrikeCorrectly() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(1, 2, 3));
		Balls ballsPickedByUser = new Balls(Arrays.asList(1, 2, 3));

		// when
		int numberOfStrike = BaseballGameController.judgeStrike(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(numberOfStrike).isEqualTo(3);
	}

	@Test
	@DisplayName("볼을 제대로 판단하는지 테스트")
	void judgeBallCorrectly() {
		// given
		Balls ballsPickedByComputer = new Balls(Arrays.asList(3, 2, 1));
		Balls ballsPickedByUser = new Balls(Arrays.asList(1, 2, 3));

		// when
		int numberOfBall = BaseballGameController.judgeBall(ballsPickedByComputer, ballsPickedByUser);

		// then
		assertThat(numberOfBall).isEqualTo(3);
	}
}
