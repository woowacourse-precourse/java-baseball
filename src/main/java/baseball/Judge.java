package baseball;

import java.util.ArrayList;
import java.util.Arrays;

public class Judge {

	private final int strike;
	private final int ball;

	public Judge(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static Judge checkScore(ArrayList<Integer> targetNumber, ArrayList<Integer> playerInputNumber){
		int strikeCount = 0;
		int ballCount = 0;
		for (int idx = 0; idx < Constant.NUMBER_LENGTH.getNumber(); idx++){
			int currTargetNumber = targetNumber.get(idx);
			if (currTargetNumber == playerInputNumber.get(idx)){
				strikeCount += 1;
				continue;
			}
			if (playerInputNumber.contains(currTargetNumber)){
				ballCount += 1;
			}
		}
		return new Judge(strikeCount, ballCount);
	}

	public static ArrayList<String> makeNumberList(String number){
		String[] numberArr = number.split("");
		return new ArrayList<>(Arrays.asList(numberArr));
	}

	// 테스트용 getter
	public int getStrike(){
		return strike;
	}

	public int getBall(){
		return ball;
	}

}
