package baseball.model;

import baseball.Util;

import java.util.Arrays;

public class Validator {
	final String INPUT_VALUE;
	final int CORRECT_LENGTH;

	public Validator(String INPUT_VALUE, int CORRECT_LENGTH) {
		this.INPUT_VALUE = INPUT_VALUE;
		this.CORRECT_LENGTH = CORRECT_LENGTH;
	}

	private void isAllNum(){
		for (int i = 0; i < INPUT_VALUE.length(); i++) {
			if (!Character.isDigit(INPUT_VALUE.charAt(i))){
				throw new IllegalArgumentException("Only digits are possible");
			}
		}
	}

	private void isCorrectSize(){
		if (INPUT_VALUE.length() != CORRECT_LENGTH){
			throw new IllegalArgumentException("The Length is wrong");
		}
	}

	private void isAllDistinctNum(){
		String distinctString = Util.getDistinctString(INPUT_VALUE);
		if (distinctString.length() != INPUT_VALUE.length()){
			throw new IllegalArgumentException("Duplicate number found");
		}
	}
}
