package baseball.model;

import baseball.utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Integer> currentUserAnswer = new ArrayList<>();

	public void init() {
		currentUserAnswer.clear();
	}

	public void setCurrentUserAnswer(String baseballNumber) {
		currentUserAnswer = Parser.parseStringToIntegerList(baseballNumber);
	}

	public List<Integer> getCurrentUserAnswer() {
		return currentUserAnswer;
	}
}
