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

	private static int countIfTrue(boolean countFlag) {
		if (countFlag)
			return (1);
		return (0);
	}

	public static boolean judge(String userInput) {
		int strike = 0;
		int ball = 0;
		int foundIndex;
		boolean foundFlag;

		for (int i = 0; i < 3; i++) {
			foundIndex = answer.indexOf(userInput.charAt(i));
			foundFlag = foundIndex != -1;
			strike += countIfTrue(foundFlag && foundIndex == i);
			ball += countIfTrue(foundFlag && foundIndex != i);
		}
		IOHandler.writeHintMessage(strike, ball);
		return (strike == 3);
	}
}
