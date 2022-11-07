package baseball.model.game;

import baseball.controller.user.User;
import baseball.model.data.Data;
import baseball.view.Output;

import static baseball.controller.Setup.*;

public class Referee {
	User user = new User();
	Rule rule = new Rule();

	public void countStrike() {

		if (rule.isStrike(Data.computerNumber, Data.computerNumIdx, Data.userNumber, Data.userNumIdx)) {
			Rule.STRIKE++;
		}
	}

	public void countBall() {
		if (rule.isBall(Data.computerNumber, Data.computerNumIdx, Data.userNumber, Data.userNumIdx)) {
			Rule.BALL++;
		}
	}

	public String getMessage() {
		StringBuilder sb = new StringBuilder();

		if (rule.isNothing()) {
			return String.valueOf(sb.append(NOTHING.getValue()));
		}

		sb.append(Rule.BALL).append(BALL.getValue()).append(" ");
		sb.append(Rule.STRIKE).append(STRIKE.getValue());

		if (Rule.STRIKE == 0) {
			return sb.toString().replaceAll("\\s[0-9]스트라이크", "");
		}

		if (Rule.BALL == 0) {
			return sb.toString().replaceAll("[0-9]볼\\s", "");
		}

		return sb.toString();

	}

	public void checkUserWin() {
		if (rule.userWin()) {
			Output.print(END_MESSAGE.getValue());
			Rule.USER_WIN = true;
			Rule.USER_INTENTION = user.getIntention();
		}
	}
}
