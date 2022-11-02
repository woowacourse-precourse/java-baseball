package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Ball {
	int number;
	
	void Ball() {
		number = randomNumberBall();
	}
	
	int randomNumberBall() {
		List<Integer> computer = new ArrayList<>();

		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer.get(0)*100+computer.get(1)*10+computer.get(2);
	}
}
