package baseball;

public class Application {
	public static void main(String[] args) {
		Operation operation = Operation.getInstance();
		operation.start();
	}
}
