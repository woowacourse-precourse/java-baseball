package baseball.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.UserBall;

class UserBallServiceTest {

	private UserBallService userBallService = new UserBallService();

	@DisplayName("makeUserBall 내부 updateStrike() 수행 테스트")
	@Test
	void updateStrikeCountTest() {
		String userInputNumber = "123";
		List<Integer> answerNumber = List.of(1, 2, 3);
		UserBall userBall = userBallService.makeUserBall(userInputNumber, answerNumber);

		UserBall userBallTest = UserBall.createUserBall();
		userBallTest.updateStrikeCount(3);
		userBallTest.updateBallCount(0);
		userBallTest.updateStatus();
		Assertions.assertThat(userBall).isEqualTo(userBallTest);
	}

	@DisplayName("makeUserBall 내부 updateBallCountTest() 수행 테스트")
	@Test
	void updateBallCountTest() {
		String userInputNumber = "214";
		List<Integer> answerNumber = List.of(1, 2, 3);
		UserBall userBall = userBallService.makeUserBall(userInputNumber, answerNumber);

		UserBall userBallTest = UserBall.createUserBall();
		userBallTest.updateStrikeCount(0);
		userBallTest.updateBallCount(2);
		userBallTest.updateStatus();
		Assertions.assertThat(userBall).isEqualTo(userBallTest);
	}

}
