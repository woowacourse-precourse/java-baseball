package baseball.model;

public class RestartValidator extends Validator{

	public RestartValidator(String inputValue, int correctLength) {
		super(inputValue, correctLength);
		isValidate();
	}

	@Override
	public void isValidate() {
		isAllNum();
		isCorrectSize();
		isOneOrTwo();
	}

	private void isOneOrTwo(){
		if (!INPUT_VALUE.equals("1") && !INPUT_VALUE.equals("2")) {
			throw new IllegalArgumentException("It should be 1 or 2");
		}
	}
}
