package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.restrict.RestrictIntegerConstants;

public class BaseballGameRuleImpl implements GameRule<Integer> {

	private static final int LIST_SIZE = RestrictIntegerConstants.LIMIT_LIST_SIZE;
	private final List<Integer> resultList = new ArrayList<>();
	private final List<Integer> userNumberList = new ArrayList<>();
	private final List<Integer> computerNumberList = new ArrayList<>();

	@Override
	public void makeResultByGameRule(List<Integer> status) {
		int countStrike = 0;
		int countBall = 0;

		if (status == null || status.size() != 2 * LIST_SIZE) {
			return;
		}
		initList(status);
		for (int numberIndex = 0; numberIndex < LIST_SIZE; numberIndex++) {
			int userNumber = userNumberList.get(numberIndex);
			int computerNumber = computerNumberList.get(numberIndex);

			if (checkStrike(userNumber, computerNumber)) {
				countStrike++;
			} else if (checkBall(userNumber)) {
				countBall++;
			}
		}
		resultList.add(countBall);
		resultList.add(countStrike);
	}

	@Override
	public List<Integer> getResultByGameRule() {
		return resultList;
	}

	private void initList(List<Integer> status) {
		clearAll();
		for (int numberIndex = 0; numberIndex < LIST_SIZE; numberIndex++) {
			int userNumber = status.get(numberIndex);
			int computerNumber = status.get(LIST_SIZE + numberIndex);

			userNumberList.add(userNumber);
			computerNumberList.add(computerNumber);
		}
	}

	private void clearAll() {
		resultList.clear();
		userNumberList.clear();
		computerNumberList.clear();
	}

	private boolean checkStrike(int userNumber, int computerNumber) {
		return userNumber == computerNumber;
	}

	private boolean checkBall(int userNumber) {
		return computerNumberList.contains(userNumber);
	}
}
