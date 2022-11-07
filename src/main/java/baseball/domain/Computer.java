package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.restrict.RestrictIntegerConstants;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer implements RestrictIntegerConstants {

	private final List<Integer> randomNumberList = new ArrayList<>();

	public void clearRandomNumberList() {
		randomNumberList.clear();
	}

	public List<Integer> getRandomNumberList() {
		return randomNumberList;
	}

	public void makeRandomNumber() {
		int randomNumber;

		clearRandomNumberList();
		while (randomNumberList.size() < LIMIT_LIST_SIZE) {
			randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!randomNumberList.contains(randomNumber)) {
				randomNumberList.add(randomNumber);
			}
		}
	}
}
