package baseball;

import static util.GameUtil.BALL_MAX_SIZE;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private ArrayList<Integer> computerBalls;

	public Computer() {
		this.computerBalls = new ArrayList<>();

		while (computerBalls.size() < BALL_MAX_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			duplicationCheck(randomNumber);
		}
	}

	public ArrayList<Integer> getComputerBalls() {
		return computerBalls;
	}

	private void duplicationCheck(int randomNumber) {
		if (!this.computerBalls.contains(randomNumber)) {
			this.computerBalls.add(randomNumber);
		}
	}

}
