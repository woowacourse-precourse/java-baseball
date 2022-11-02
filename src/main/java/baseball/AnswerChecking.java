package baseball;

public class AnswerChecking {

	public static boolean checkAnswer(int ans, int userInputAns) {
		return ans == userInputAns;
	}

	public static boolean isSameNumber(int hundreds, int tens, int units) {
		return hundreds == tens || hundreds == units || tens == units;
	}

}
