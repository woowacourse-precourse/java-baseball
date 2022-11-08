package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

	public PlayResult judge(Balls playerBalls, Balls computerBalls) {
		Map<BallStatus, Integer> ballStatusCount = new HashMap<>();
		List<BallStatus> ballStatuses = playerBalls.compare(computerBalls);
		for (BallStatus ballStatus : ballStatuses) {
			checkBallStatus(ballStatus, ballStatusCount);
		}
		return new PlayResult(ballStatusCount.getOrDefault(BallStatus.BALL, 0),
			ballStatusCount.getOrDefault(BallStatus.STRIKE, 0));
	}

	private void checkBallStatus(BallStatus ballStatus, Map<BallStatus, Integer> ballStatusCount) {
		ballStatusCount.put(ballStatus, ballStatusCount.getOrDefault(ballStatus, 0) + 1);
	}
}
