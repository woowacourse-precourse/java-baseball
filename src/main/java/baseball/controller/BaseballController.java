package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.model.BaseballRequest;
import baseball.model.BaseballResponse;
import baseball.model.MatchDto;
import baseball.model.RestartOrExitRequest;
import baseball.printer.BaseballPrinter;
import baseball.service.BaseballService;
import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballController {

	private final BaseballService baseballService = new BaseballService();
	private final BaseballValidator baseballValidator = new BaseballValidator();
	private final BaseballPrinter baseballPrinter = new BaseballPrinter();
	private final int chooseNumber;

	private BaseballController() {
		final List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		this.chooseNumber = computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
	}

	public static BaseballController of() {
		return new BaseballController();
	}

	public boolean play(int requestNumber) {
		if (!baseballValidator.validate(BaseballRequest.of(requestNumber))) {
			throw new IllegalArgumentException();
		}
		final BaseballResponse response = baseballService.match(MatchDto.of(requestNumber, chooseNumber));
		baseballPrinter.print(response);
		return response.isStrikeOut();
	}

	public boolean restart(int type) {
		if (!baseballValidator.validate(RestartOrExitRequest.of(type))) {
			throw new IllegalArgumentException();
		}
		return type == 1;
	}

}
