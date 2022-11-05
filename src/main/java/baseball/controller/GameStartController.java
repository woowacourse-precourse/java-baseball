package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class GameStartController {

	private final InputView inputView;

	public GameStartController(InputView inputView) {
		this.inputView = inputView;
	}

	public List<Integer> initGame() {
		List<Integer> answer = makeAnswerNumber();
		printGameStart();
		return answer;
	}

	private void printGameStart() {
		inputView.printGameStart();
	}

	private List<Integer> makeAnswerNumber() {
		List<Integer> answer = new ArrayList<>();
		while (answer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
		return answer;
	}

}
