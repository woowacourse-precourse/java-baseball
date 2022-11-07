package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Opponent {

	private static final int MIN_DIGIT = 1;
	private static final int MAX_DIGIT = 9;
	private static final int DIGIT_LENGTH = 3;
	private static List<Integer> answer = new ArrayList<>();

	public void generateAnswerNumber() {
		answer.clear();
		while (answer.size() < DIGIT_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
	}

	public List<Integer> getAnswer() {
		return answer;
	}
}
