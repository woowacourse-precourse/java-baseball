package baseball;

public class Application {
	public static void main(String[] args) {
		Computer computer = new Computer();
		User.getUserInput();
		Comparison comparison = new Comparison(User.userNums, computer.computerNums);
	}
}
