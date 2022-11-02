package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private static final int MIN_RANDOM_NUMBER = 1;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int RANDOM_NUMBER_COUNT = 3;

	private List<Integer> answerNumberList = new ArrayList<>();

	public Computer() {
		init();
	}

	public void init() {
		answerNumberList = generateRandomNumberList();
	}

	public List<Integer> generateRandomNumberList() {
		return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, RANDOM_NUMBER_COUNT);
	}

	public List<Integer> getAnswerList() {
		return answerNumberList;
	}
}
