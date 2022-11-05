package baseball.model.game;

import baseball.controller.user.User;
import baseball.model.data.Data;
import baseball.view.Output;

import static baseball.controller.Setup.*;

public class Judge {
	User user = new User();
	Data data = new Data();
	Rule rule = new Rule();
	Output output = new Output();

	public void countStrike() {

		if (rule.isStrike(data.computerNumber, data.computerNumIdx, data.userNumber, data.userNumIdx)) {
			rule.STRIKE++;
		}
	}

	public void countBall() {
		if (rule.isBall(data.computerNumber, data.computerNumIdx, data.userNumber, data.userNumIdx)) {
			rule.BALL++;
		}
	}

	public String getMessage() {
		StringBuilder sb = new StringBuilder();

		if (rule.isNothing()) {
			return String.valueOf(sb.append("낫싱"));
		}

		sb.append(rule.BALL).append("볼 ");
		sb.append(rule.STRIKE).append("스트라이크");

		if (rule.STRIKE == 0) {
			return sb.toString().replaceAll("\\s[0-9]스트라이크", "");
		}

		if (rule.BALL == 0) {
			return sb.toString().replaceAll("[0-9]볼\\s", "");
		}

		return sb.toString();

	}

	public void checkUserWin() {
		if (rule.userWin()) {
			output.print(END_MESSAGE.getValue());
			rule.USER_WIN = true;
			rule.USER_INTENTION = user.getIntention();
		}
	}

}
