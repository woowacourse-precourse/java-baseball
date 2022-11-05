package baseball.model.game;

import baseball.model.data.Data;

public class Calculation {

	Judge judge = new Judge();
	Data data = new Data();

	public void calculateGuess() {

		for (int comIdx = 0; comIdx < data.getComNumMap().size(); comIdx++) {
			for (int userIdx = 0; userIdx < data.getUserNumMap().size(); userIdx++) {
				data.checkEachNumAndIdx(comIdx, userIdx);
				judge.countStrike();
				judge.countBall();

			}
		}
	}
}
