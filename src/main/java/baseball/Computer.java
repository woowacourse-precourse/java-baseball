package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Computer {
	private List<Integer> numbers;

	public Computer() {
		numbers = new ArrayList<>();
//		numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
		while (numbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(randomNumber)) numbers.add(randomNumber);
		}
		System.out.println("numbers = " + numbers);
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

}
