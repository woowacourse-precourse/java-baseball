package baseball;

import java.util.LinkedList;
import java.util.List;

public class Referee {

	public boolean isNothing(List<Integer> computerBalls, List<Integer> playerBalls) {
		List<Integer> sameBalls = new LinkedList<>();
		sameBalls.addAll(computerBalls);
		sameBalls.retainAll(playerBalls);

		if (sameBalls.isEmpty()) {
			return true;
		}
		return false;
	}

	public int countStrikeNum(List<Integer> computerBalls, List<Integer> playerBalls) {
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
}