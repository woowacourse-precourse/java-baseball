package baseball.model.numberbaseball.application;

import java.util.List;

import baseball.common.Constants;
import baseball.model.gameresult.GameResult;
import baseball.model.gameresult.ResultType;
import baseball.model.numberbaseball.NumberBaseball;
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

	public GameResult compareNumberBaseBall(NumberBaseball computerNumber, NumberBaseball userNumber) {
		GameResult gameResult = new GameResult();

		for (int i = 0; i < Constants.NUMBER_BASEBALL_LENGTH; i++) {
			int number = userNumber.getNumberAt(i);
			ResultType resultType = calculateSingleResult(computerNumber, i, number);
			gameResult.addSingleResult(resultType);
		}

		return gameResult;
	}

	private ResultType calculateSingleResult(NumberBaseball computerNumber, int index, int number) {
		if (computerNumber.getNumberAt(index) == number) {
			return ResultType.STRIKE;
		} else if (computerNumber.contains(number)) {
			return ResultType.BALL;
		}

		return ResultType.NOTHING;
	}
}
