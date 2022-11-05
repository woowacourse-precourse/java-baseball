package baseball;

import java.util.HashSet;
import java.util.List;

public class Grader {

	private List<Integer> answerList;
	private HashSet<Integer> answerSet;

	public Grader(List<Integer> answer) {
		this.answerList = answer;
		this.answerSet = new HashSet<>(answer);
	}

	public Score getScore(List<Integer> input) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			int tgt = input.get(i);
			if (tgt == answerList.get(i)) {
				strike++;
				continue;
			}
			if (answerSet.contains(tgt)) {
				ball++;
			}
		}
		return new Score(ball, strike);
	}

	public boolean isCorrect(Score score) {
		if (score.getStrike() == 3) {
			return true;
		}
		return false;
	}
}
