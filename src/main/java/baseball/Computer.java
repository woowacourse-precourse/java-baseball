package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Computer {
	List<Integer> numberList;
	private final int SIZE;

	Computer(final int SIZE) {
		this.SIZE = SIZE;
	}

	void getThreeRandomNumber() {
		numberList = new ArrayList<>();

		while (numberList.size() < SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}
}