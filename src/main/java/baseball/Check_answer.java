package baseball;

public class Check_answer {
	public int check_strike(int[] answer, int[] guessnumber) {
		int strike = 0;

		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == guessnumber[i]) {
				strike++;
			}
		}

		return strike;
	}

	public int check_ball(int[] answer, int[] guessnumber) {
		int ball = 0;

		if (answer[0] == guessnumber[1] || answer[0] == guessnumber[2]) {
			ball++;
		}
		if (answer[1] == guessnumber[0] || answer[1] == guessnumber[2]) {
			ball++;
		}
		if (answer[2] == guessnumber[0] || answer[2] == guessnumber[1]) {
			ball++;
		}

		return ball;
	}
}