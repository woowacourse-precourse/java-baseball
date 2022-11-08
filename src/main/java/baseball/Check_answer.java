package baseball;

public class Check_answer {
	public int check_strike(int[] input, int[] guessnumber) {
		int strike = 0;

		for (int i = 0; i < input.length; i++) {
			if (input[i] == guessnumber[i]) {
				strike++;
			}
		}

		return strike;
	}

	public int check_ball(int[] input, int[] guessnumber) {
		int ball = 0;

		if (input[0] == guessnumber[1] || input[0] == guessnumber[2]) {
			ball++;
		}
		if (input[1] == guessnumber[0] || input[1] == guessnumber[2]) {
			ball++;
		}
		if (input[2] == guessnumber[0] || input[2] == guessnumber[1]) {
			ball++;
		}

		return ball;
	}
}