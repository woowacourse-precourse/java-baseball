package baseball.input;

public enum Number {
	MIN(1), MAX(9);

	private int number;

	Number(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
