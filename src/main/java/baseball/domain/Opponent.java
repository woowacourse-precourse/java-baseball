package baseball.domain;

import java.util.List;

public class Opponent {

	List<Integer> answerNumbers;

	public Opponent(List<Integer> answerNumbers) {
		this.answerNumbers = answerNumbers;
	}

	public List<Integer> getAnswerNumbers() {
		return answerNumbers;
	}
}
