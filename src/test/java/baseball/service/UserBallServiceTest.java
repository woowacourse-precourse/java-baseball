package baseball.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.UserBall;

class UserBallServiceTest {

	private UserBallService userBallService = new UserBallService();

	@DisplayName("makeUserBall 메서드에서 올바른 userBall 을 확인하는 테스트")
	@Test
	void makeUserBall() {
		String userInputNumber = "123";
		List<Integer> answerNumber = List.of(1, 2, 3);
		UserBall userBall = userBallService.makeUserBall(userInputNumber, answerNumber);

		UserBall userBallTest = UserBall.createUserBall();
		userBallTest.updateStrikeCount(3);
		userBallTest.updateBallCount(0);
		userBallTest.updateStatus();
		Assertions.assertThat(userBall).isEqualTo(userBallTest);
	}

}
