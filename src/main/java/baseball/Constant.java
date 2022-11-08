package baseball;

public enum Constant {
	MIN_VALUE(1),
	MAX_VALUE(9),
	NUMBER_LENGTH(3),
	RESTART(1),
	END_GAME(2);

	private final int number;

	Constant(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}
}
