package baseball;

import java.util.Arrays;
import java.util.List;

public class User {
	private List<String> numberList;
	private int ball;
	private int strike;

	public User(String number) {
		validateNumberLength(number);
		this.numberList = Arrays.asList(number.trim().split(""));
		validateNumberList(this.numberList);
		this.ball = 0;
		this.strike = 0;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	private void validateNumberLength(String number) {
		if(number.trim().length() != Game.DIGIT_NUMBER) {
			throw new IllegalArgumentException(Message.INVALID_ARGUMENT_EXCEPTION_MESSAGE);
		}
	}

	private void validateNumberList(List<String> numberList) {
		if(numberList.get(0).equals("0")) {
			throw new IllegalArgumentException(Message.INVALID_ARGUMENT_EXCEPTION_MESSAGE);
		}
	}

	public void calculateBallAndStrike(List<String> opponentNumberList) {
		for(String number : numberList) {
			if(numberList.indexOf(number) == opponentNumberList.indexOf(number)) {
				strike++;
			}
			if(opponentNumberList.indexOf(number) != -1 && numberList.indexOf(number) != opponentNumberList.indexOf(number)) {
				ball++;
			}
		}
	}
}
