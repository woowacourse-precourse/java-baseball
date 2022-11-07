package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Pitcher {
	private final List<Integer> number = new ArrayList<>(3);

	public Pitcher() {
		while (number.size() < 3) {
			int tmpNum = Randoms.pickNumberInRange(1, 9);
			if (number.contains(tmpNum) == false) {
				number.add(tmpNum);
			}
		}
	}

	public List<Integer> getNumber() {
		return number;
	}
}
