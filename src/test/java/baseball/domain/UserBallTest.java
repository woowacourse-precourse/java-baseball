package baseball.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.service.UserBallService;

class UserBallTest {

	private UserBallService userBallService = new UserBallService();

	@DisplayName("스트라이크 개수가 3이면 isStrike 메서드에서 true 반환 아니면, false 를 반환한다")
	@Test
	void is3Strike() {
		Integer strikeCount1 = 3;
		UserBall userBallTrue = UserBall.createUserBall();
		userBallTrue.updateStrikeCount(strikeCount1);
		userBallTrue.updateStatus();
		Assertions.assertThat(userBallTrue.is3Strike()).isTrue();

		Integer strikeCount2 = 2;
		UserBall userBallFalse = UserBall.createUserBall();
		userBallFalse.updateStrikeCount(strikeCount2);
		userBallFalse.updateStatus();
		Assertions.assertThat(userBallFalse.is3Strike()).isFalse();
	}

	@DisplayName("볼 개수를 업데이트 하면 그에 따른 userBall 의 상태가 볼개수+볼 문자열 상태를 가진다")
	@Test
	void updateBallCount() {
		Integer ballCount = 2;
		UserBall userBall = UserBall.createUserBall();
		userBall.updateBallCount(ballCount);
		userBall.updateStatus();

		Assertions.assertThat(userBall.createUserBallStatusStringDto()).isEqualTo(ballCount + "볼");
	}

	@DisplayName("스트라이크 개수를 업데이트 하면 그에 따른 userBall 의 상태가 스트라이크개수+스트라이크 문자열 상태를 가진다")
	@Test
	void updateStrikeCount() {
		Integer strikeCount = 2;
		UserBall userBall = UserBall.createUserBall();
		userBall.updateStrikeCount(strikeCount);
		userBall.updateStatus();

		Assertions.assertThat(userBall.createUserBallStatusStringDto()).isEqualTo(strikeCount + "스트라이크");
	}

	@DisplayName("모든 ball, strike 개수에 따른 userball 상태필드 업데이트 확인 테스트")
	@Test
	void updateStatus() {
		List<String> strikeCase = List.of("513", "153", "317", "157", "135", "789");
		List<String> strikeCaseUserBallStatus = List.of("3볼", "2볼 1스트라이크", "2볼", "1볼 1스트라이크", "3스트라이크", "낫싱");
		List<Integer> strikeAnswer = List.of(1, 3, 5);
		for (int i = 0; i < 6; i++) {
			UserBall userBall = userBallService.makeUserBall(strikeCase.get(i), strikeAnswer);
			Assertions.assertThat(userBall.createUserBallStatusStringDto()).isEqualTo(strikeCaseUserBallStatus.get(i));
		}

		List<String> ballCase = List.of("153", "137", "153", "157", "135");
		List<String> ballCaseUserBallStatus = List.of("2볼 1스트라이크", "2스트라이크", "2볼 1스트라이크", "1볼 1스트라이크", "3스트라이크");
		List<Integer> ballAnswer = List.of(1, 3, 5);
		for (int i = 0; i < 5; i++) {
			UserBall userBall = userBallService.makeUserBall(ballCase.get(i), ballAnswer);
			Assertions.assertThat(userBall.createUserBallStatusStringDto()).isEqualTo(ballCaseUserBallStatus.get(i));
		}
	}
}
