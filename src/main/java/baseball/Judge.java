package baseball;

import java.util.List;

public class Judge {
	Compare compare = new Compare();

	public String judgement(List<Integer> computer, List<Integer> player) {
		int total = compare.howMany(computer, player);
		int strike = compare.countStrike(computer, player);
		int ball = compare.countBall(computer, player);
		return message(total, strike, ball);
	}

	public String message(int total, int strike, int ball) {
		if (total == 0) {
			return "낫싱";
		}
		if (ball != 0 && strike == 0) {
			return ball + "볼";
		}
		if (ball == 0 && strike != 0) {
			return strike + "스트라이크";
		}
		return ball + "볼 " + strike + "스트라이크";

	}
}