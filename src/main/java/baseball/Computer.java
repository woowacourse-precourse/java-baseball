package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

;

public class Computer {
	List<Integer> answer = new ArrayList<>();

	public Computer() {
		setAnswer(answer);
	}

	private List<Integer> setAnswer(List<Integer> answer) {
		while (answer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
		return answer;
	}

}