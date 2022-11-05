package baseball;

import java.util.List;

public class FlowHandler {

	private IOHandler io = new IOHandler();
	private BaseballNumberGenerator generator = new BaseballNumberGenerator();

	public int runGame() {
		List<Integer> baseballNumber = generator.getBaseballNumber();
		io.printInitMessage();
		io.printInputMessage();
		Grader grader = new Grader(baseballNumber);
		List<Integer> inputList = io.getInputList();
		io.printScore(grader.getScore(inputList));

		return 1;
	}
}
