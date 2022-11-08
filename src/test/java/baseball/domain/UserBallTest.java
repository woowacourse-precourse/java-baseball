package baseball.domain;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.service.UserBallService;

class UserBallTest {

	private UserBallService userBallService = new UserBallService();

	@ParameterizedTest(name = "스트라이크 개수가 3이면 isStrike 메서드에서 true 반환 아니면, false 를 반환한다")
	@CsvSource(value = {"3, true", "2, false"})
	void is3Strike(Integer strikeCount, boolean expected) {
		UserBall userBallTrue = UserBall.createUserBall();
		userBallTrue.updateStrikeCount(strikeCount);
		userBallTrue.updateStatus();
		Assertions.assertThat(userBallTrue.is3Strike()).isEqualTo(expected);
	}

	@DisplayName("볼 개수로 updateBallCount 시 userball 의 ball 상태 변화 확인 테스트")
	@Test
	void updateBallCount() {
		Integer ballCount = 2;
		UserBall userBall = UserBall.createUserBall();
		userBall.updateBallCount(ballCount);
		userBall.updateStatus();

		UserBall userBallTest = new UserBall(ballCount, 0);
		userBallTest.updateStatus();

		Assertions.assertThat(userBall).isEqualTo(userBallTest);
	}

	@DisplayName("스트라이크 개수로 updateStrikeCount 시 userball 의 strike 상태 변화 확인 테스트")
	@Test
	void updateStrikeCount() {
		Integer strikeCount = 2;
		UserBall userBall = UserBall.createUserBall();
		userBall.updateStrikeCount(strikeCount);
		userBall.updateStatus();

		UserBall userBallTest = new UserBall(0, strikeCount);
		userBallTest.updateStatus();

		Assertions.assertThat(userBall).isEqualTo(userBallTest);
	}

	private static Stream<Arguments> provideForResult() {
		return Stream.of(
			Arguments.of(List.of("513", "153", "317", "157", "135", "789"),
				List.of("3볼", "2볼 1스트라이크", "2볼", "1볼 1스트라이크", "3스트라이크", "낫싱"),
				List.of(1, 3, 5), 6),
			Arguments.of(List.of("153", "137", "153", "157", "135"),
				List.of("2볼 1스트라이크", "2스트라이크", "2볼 1스트라이크", "1볼 1스트라이크", "3스트라이크"),
				List.of(1, 3, 5), 5)
		);
	}

	@ParameterizedTest(name = "모든 ball, strike 개수에 따른 userball 상태필드 업데이트 확인 테스트")
	@MethodSource("provideForResult")
	void updateStatus(List<String> userInput, List<String> userBallStatus, List<Integer> answer, Integer size) {
		for (int i = 0; i < size; i++) {
			UserBall userBall = userBallService.makeUserBall(userInput.get(i), answer);
			Assertions.assertThat(userBall.createUserBallStatusStringDto()).isEqualTo(userBallStatus.get(i));
		}
	}
}
