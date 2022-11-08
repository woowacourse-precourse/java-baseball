package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Opponent {
	private static String answer;

	private static void appendIfUnique(int pickedNumber) {
		if (!answer.contains(Integer.toString(pickedNumber)))
			answer += pickedNumber;
	}

	public static void initAnswer() {
		int pickedNumber;

		answer = "";
		while (answer.length() < 3) {
			pickedNumber = pickNumberInRange(1, 9);
			appendIfUnique(pickedNumber);
		}
	}
}
