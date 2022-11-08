package baseball;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private List<Integer> playerBalls = new LinkedList<>();

	public void pitchThreeUniqueBalls(String balls) {
		initBalls();
		for (int ballIdx = 0; ballIdx < balls.length(); ballIdx++) {
			int uniqueBall = balls.charAt(ballIdx) - '0';
			playerBalls.add(uniqueBall);
		}
	}

	private void initBalls() {
		playerBalls.clear();
	}

	public List<Integer> getPlayerBalls() {
		return playerBalls;
	}
}