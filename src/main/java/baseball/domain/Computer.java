package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;
	public static final int ANSWER_LENGTH = 3;
	private List<Integer> answer;

	public void createAnswer() {
		Set<Integer> numSet = new HashSet<>();

		while (numSet.size() != ANSWER_LENGTH) {
			numSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
		answer = new ArrayList<>(numSet);
	}

	public List<Integer> getAnswer() {
		return answer;
	}
}
