package baseball.model.application;

import static baseball.common.Constant.*;

import java.util.List;

import baseball.model.NumberBaseball;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballService {

	public NumberBaseball createNumberBaseball() {
		List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(
			NUMBER_BASEBALL_MIN_VALUE,
			NUMBER_BASEBALL_MAX_VALUE,
			NUMBER_BASEBALL_LENGTH
		);

		return new NumberBaseball(uniqueNumbersInRange);
	}
}
