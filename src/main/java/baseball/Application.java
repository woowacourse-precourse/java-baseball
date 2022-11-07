package baseball;

import baseball.operator.Operator;

public class Application {
	public static void main(String[] args) {

		Operator operator;

		do {
			operator = new Operator();
			operator.run();
		} while (operator.requestRestart());
	}
}
