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
}