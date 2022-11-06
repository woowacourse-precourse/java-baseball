package baseball.domain;

import java.util.List;

public class Opponent {
	List<Integer> answerNumbers;

	public Opponent(List<Integer> answerNumbers, int strikeCount, int ballCount) {
		this.answerNumbers = answerNumbers;
	}

	public List<Integer> getAnswerNumbers() {
		return answerNumbers;
	}
}
