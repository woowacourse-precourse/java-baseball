package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
	static final int MAX_LIST_SIZE = 3;
	static final int MIN_RANGE = 1;
	static final int MAX_RANGE = 9;
	List<Integer> computersList = new ArrayList<>();

	Computer() {}

	public void setComputersList() {
		while(computersList.size() < MAX_LIST_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

			if(!computersList.contains(randomNumber)) {
				computersList.add(randomNumber);
			}
		}
	}

	public List<Integer> getComputersList() {
		return getComputersList();
	}
}
