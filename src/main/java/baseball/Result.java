package baseball;

import java.util.List;

public class Result {
	public static int getBallCount(List<Integer> pitcher, List<Integer> hitter) {
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcher.contains(hitter.get(i))) {
				ball++;
			}
		}

		ball -= getStrikeCount(pitcher, hitter);
		return ball;
	}

	public static int getStrikeCount(List<Integer> pitcher, List<Integer> hitter) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcher.get(i) == hitter.get(i)) {
				strike++;
			}
		}

		return strike;
	}

	public static String getResult(int ballCount, int strikeCount) {
		String resultStr = "";
		if (ballCount > 0 && strikeCount > 0) {
			resultStr = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
		} else if (ballCount == 0 && strikeCount == 0) {
			resultStr = "낫싱";
		} else if (strikeCount == 0) {
			resultStr = String.format("%d볼", ballCount);
		} else if (ballCount == 0) {
			resultStr = String.format("%d스트라이크", strikeCount);
			if (strikeCount == 3) {
				resultStr += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
			}
		}

		return resultStr;
	}
}
