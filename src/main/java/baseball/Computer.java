package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {
	static List<Integer> numberList;

	static void getThreeRandomNumber() {
		numberList = new ArrayList<>();
		while (numberList.size() < Game.SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}
}