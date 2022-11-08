package baseball;

import java.util.List;

public class FlowHandler {

	private OutputHandler output = new OutputHandler();
	private InputHandler input = new InputHandler();
	private BaseballNumberGenerator generator = new BaseballNumberGenerator();

	public int runGame() {
		List<Integer> baseballNumber = generator.getBaseballNumber();
		Grader grader = new Grader(baseballNumber);
		output.printInitMessage();
		while (true) {
			output.printInputMessage();
			List<Integer> inputList = input.getInputList();
			Score score = grader.getScore(inputList);
			output.printScore(score);
			if (grader.isCorrect(score)) {
				output.printGameEndMessage();
				return input.getRestartInt();
			}
		}
	}
}
