package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
	List<Integer> computersList = new ArrayList<>();

	Computer() {}

	public void setComputersList() {
		while(computersList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if(!computersList.contains(randomNumber)) {
				computersList.add(randomNumber);
			}
		}
	}

	public List<Integer> getComputersList() {
		return getComputersList();
	}
}
