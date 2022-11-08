package baseball.model;

import baseball.Util;

public class TryValidator extends Validator{
	public TryValidator(String inputValue, int correctLength) {
		super(inputValue, correctLength);
		isValidate();
	}

	@Override
	public void isValidate() {
		isCorrectSize();
		isAllNum();
		isAllDistinctNum();
	}
	public void isAllDistinctNum(){
		String distinctString = Util.getDistinctString(INPUT_VALUE);
		if (distinctString.length() != INPUT_VALUE.length()) {
			throw new IllegalArgumentException("Duplicate number found");
		}
	}
}
