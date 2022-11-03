package baseball.controller;

import baseball.controller.dto.UserPlayNumbers;
import baseball.model.NumberBaseball;
import baseball.model.application.NumberBaseballService;
import baseball.view.NumberBaseballView;

public class NumberBaseballController {
	private final NumberBaseballView numberBaseballView = new NumberBaseballView();
	private final NumberBaseballService numberBaseballService = new NumberBaseballService();

	public void initGame() {
		numberBaseballView.initPage();
	}
	public void playBall() {
		NumberBaseball computerNumber = numberBaseballService.createNumberBaseball();
		UserPlayNumbers userPlayNumbers = numberBaseballView.playPage();
	}
}
