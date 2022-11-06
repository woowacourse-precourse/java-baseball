package game.player;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> computersDifferentThreeNumbers = new ArrayList<>();
	private int strike;
	private int ball;

	public Computer() {
		while (computersDifferentThreeNumbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computersDifferentThreeNumbers.contains(randomNumber)) {
				computersDifferentThreeNumbers.add(randomNumber);
			}
		}
	}
}
