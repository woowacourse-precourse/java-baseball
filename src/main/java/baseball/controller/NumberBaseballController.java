package baseball.controller;

import baseball.model.NumberBaseball;
import baseball.model.application.NumberBaseballService;
import baseball.view.NumberBaseballView;

public class NumberBaseballController {
	private final NumberBaseballView numberBaseballView = new NumberBaseballView();
	private final NumberBaseballService numberBaseballService = new NumberBaseballService();

	public void playBall() {
		NumberBaseball computerNumber = numberBaseballService.createNumberBaseball();
	}
}
