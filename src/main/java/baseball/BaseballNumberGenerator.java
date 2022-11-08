package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {

	public List<Integer> getBaseballNumber() {
		List<Integer> baseballNumber = new ArrayList<>();
		while (baseballNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!baseballNumber.contains(randomNumber)) {
				baseballNumber.add(randomNumber);
			}
		}
		return baseballNumber;
	}
}
