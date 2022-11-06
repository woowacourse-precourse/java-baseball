package baseball.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.service.AnswerService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerController {
	private AnswerController() {}

	private static AnswerController instance;

	public static AnswerController getInstance() {
		if(instance == null) {
			instance = new AnswerController();
		}
		return instance;
	}

	public List<Integer> setCorrectAnswer() {
		Set<Integer> numbers = new HashSet<>();
		while(numbers.size() < 3) {
			numbers.add(Randoms.pickNumberInRange(1,9));
		}
		return new ArrayList<>(numbers);
	}

	public void getInputAnswer() {
		OutputView.alertInputAnswer();
		AnswerService.getInstance().validateInputAnswer(InputView.getInput());
	}
}
