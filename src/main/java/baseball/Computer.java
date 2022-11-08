package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
	private List<String> numberList;

	public Computer() {
		this.numberList = makeRandomNumber();
	}

	public List<String> getRandomNumberList() {
		return numberList;
	}

	private List<String> makeRandomNumber() {
		Set<String> randomNumberSet = new HashSet<>();

		while(randomNumberSet.size() < Game.DIGIT_NUMBER) {
			randomNumberSet.add(String.valueOf(Randoms.pickNumberInRange(1, 9)));
		}

		return new ArrayList<>(randomNumberSet);
	}
}
