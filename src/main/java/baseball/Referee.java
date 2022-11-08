package baseball;

import java.util.LinkedList;
import java.util.List;

public class Referee {

	public String judge(List<Integer> computerBalls, List<Integer> playerBalls) {
		String gameResult = "";

		if (isNothing(computerBalls, playerBalls)) {
			gameResult = "낫싱";
			return gameResult;
		}

		int ballNum = countBallNum(computerBalls, playerBalls);
		int strikeNum = countStrikeNum(computerBalls, playerBalls);

		if (ballNum > 0) {
			gameResult = gameResult + ballNum + "볼 ";
		}

		if (strikeNum > 0) {
			gameResult = gameResult + strikeNum + "스트라이크";
		}
		
		gameResult = gameResult.trim();
		return gameResult;
	}

	private boolean isNothing(List<Integer> computerBalls, List<Integer> playerBalls) {
		List<Integer> sameBalls = new LinkedList<>();
		sameBalls.addAll(computerBalls);
		sameBalls.retainAll(playerBalls);

		if (sameBalls.isEmpty()) {
			return true;
		}
		return false;
	}

	private int countStrikeNum(List<Integer> computerBalls, List<Integer> playerBalls) {
		int strikeNum = 0;
		for (int ballIdx = 0; ballIdx < computerBalls.size(); ballIdx++) {
			int computerBall = computerBalls.get(ballIdx);
			int playerBall = playerBalls.get(ballIdx);

			if (computerBall == playerBall) {
				strikeNum += 1;
			}
		}
		return strikeNum;
	}

	private int countBallNum(List<Integer> computerBalls, List<Integer> playerBalls) {
		int ballNum = 0;
		for (int ballIdx = 0; ballIdx < computerBalls.size(); ballIdx++) {
			int computerBall = computerBalls.get(ballIdx);
			int playerBall = playerBalls.get(ballIdx);

			if (!canBall(computerBalls, playerBall)) {
				continue;
			}
			
			if (computerBall != playerBall) {
				ballNum += 1;
			}
		}
		return ballNum;
	}

	private boolean canBall(List<Integer> computerBalls, int playerBall) {
		return computerBalls.contains(playerBall);
	}
}