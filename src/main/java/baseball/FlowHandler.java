package baseball;

import java.util.List;

public class FlowHandler {

	private IOHandler io = new IOHandler();
	private BaseballNumberGenerator generator = new BaseballNumberGenerator();

	public int runGame() {
		List<Integer> baseballNumber = generator.getBaseballNumber();
		Grader grader = new Grader(baseballNumber);
		io.printInitMessage();
		while (true) {
			io.printInputMessage();
			List<Integer> inputList = io.getInputList();
			Score score = grader.getScore(inputList);
			io.printScore(score);
			if (grader.isCorrect(score)) {
				io.printGameEndMessage();
				return io.getRestartInt();
			}
		}
	}
}
