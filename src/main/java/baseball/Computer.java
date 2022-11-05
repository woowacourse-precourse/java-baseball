package baseball;

import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> computerBalls = new LinkedList<>();

	public void pitchThreeUniqueBalls() {
		initBalls();
		while (computerBalls.size() < 3) {
			int ball = Randoms.pickNumberInRange(1, 9);
			if (!computerBalls.contains(ball)) {
				computerBalls.add(ball);
			}
		}
	}

	private void initBalls() {
		computerBalls.clear();
	}

	public List<Integer> getComputerBalls() {
		return computerBalls;
	}
}