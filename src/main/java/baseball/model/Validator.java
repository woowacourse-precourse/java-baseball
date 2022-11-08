package baseball.model;

public abstract class Validator {
	public final String INPUT_VALUE;
	final int CORRECT_LENGTH;

	public Validator(String inputValue, int correctLength) {
		this.INPUT_VALUE = inputValue;
		this.CORRECT_LENGTH = correctLength;
	}

	public abstract void isValidate();

	protected void isAllNum(){
		for (int i = 0; i < INPUT_VALUE.length(); i++) {
			if (!Character.isDigit(INPUT_VALUE.charAt(i))) {
				throw new IllegalArgumentException("Only digits are possible");
			}
		}
	}

	protected void isCorrectSize(){
		if (INPUT_VALUE.length() != CORRECT_LENGTH) {
			throw new IllegalArgumentException("The Length is wrong");
		}
	}

}
