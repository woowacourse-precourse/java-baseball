package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNum {

	public List<Integer> create() {
		List<Integer> computerNumber = new ArrayList<>();
		while (computerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			overlapCheck(computerNumber, randomNumber);
		}
		return computerNumber;
	}
}
