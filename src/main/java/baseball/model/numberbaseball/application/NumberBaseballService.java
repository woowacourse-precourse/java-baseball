package baseball.model.numberbaseball.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.common.Constants;
import baseball.model.gameresult.GameResult;
import baseball.model.gameresult.SingleResultType;
import baseball.model.numberbaseball.NumberBaseball;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballService {

	public NumberBaseball createNumberBaseball() {
		List<Integer> uniqueNumbersInRange = getUniqueNumbersInRange(
			Constants.NUMBER_BASEBALL_MIN_VALUE,
			Constants.NUMBER_BASEBALL_MAX_VALUE,
			Constants.NUMBER_BASEBALL_LENGTH
		);

		return new NumberBaseball(uniqueNumbersInRange);
	}

	private List<Integer> getUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
		Set<Integer> uniqueNumbers = new LinkedHashSet<>(count);
		while (uniqueNumbers.size() != count) {
			uniqueNumbers.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
		}

		return new ArrayList<>(uniqueNumbers);
	}

	public GameResult compareNumberBaseBall(NumberBaseball computerNumber, NumberBaseball userNumber) {
		GameResult gameResult = new GameResult();

		for (int i = 0; i < Constants.NUMBER_BASEBALL_LENGTH; i++) {
			int number = userNumber.getNumberAt(i);
			SingleResultType singleResultType = calculateSingleResult(computerNumber, i, number);
			gameResult.addSingleResult(singleResultType);
		}

		return gameResult;
	}

	private SingleResultType calculateSingleResult(NumberBaseball computerNumber, int index, int number) {
		if (computerNumber.getNumberAt(index) == number) {
			return SingleResultType.STRIKE;
		} else if (computerNumber.contains(number)) {
			return SingleResultType.BALL;
		}

		return SingleResultType.NOTHING;
	}
}
