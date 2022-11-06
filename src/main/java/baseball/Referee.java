package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {

	public boolean isNothing(List<Integer> computerBalls, List<Integer> playerBalls) {
		int sameBallCount = 0;
		Set<Integer> sameBalls = new HashSet<Integer>(computerBalls);
		for (int playerBall : playerBalls) {
			if (sameBalls.contains(playerBall)) {
				sameBallCount += 1;
			}
		}
		if (sameBallCount == 0) {
			return true;
		}
		return false;
	}
}