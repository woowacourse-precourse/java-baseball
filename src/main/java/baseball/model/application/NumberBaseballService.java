package baseball.model.application;

import java.util.List;

import baseball.common.Constants;
import baseball.model.NumberBaseball;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballService {

	public NumberBaseball createNumberBaseball() {
		List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(
			Constants.NUMBER_BASEBALL_MIN_VALUE,
			Constants.NUMBER_BASEBALL_MAX_VALUE,
			Constants.NUMBER_BASEBALL_LENGTH
		);

		return new NumberBaseball(uniqueNumbersInRange);
	}

	public String compareNumberBaseBall(NumberBaseball computerNumber, NumberBaseball userNumber) {

	}
}
