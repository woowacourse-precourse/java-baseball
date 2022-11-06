package baseball;

import static baseball.GameRules.*;

import java.util.Collections;
import java.util.List;

public class BaseballGameModel {
	private final ComputerPlayer computerPlayer;
	private UserPlayer userPlayer = UserPlayer.getInstance();
	private List<Integer> computerNumbers;
	private List<Integer> userNumbers;
	private int strike = 0;
	private int ball = 0;

	public BaseballGameModel(ComputerPlayer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	public List<Integer> getMatchResult() {
		computerNumbers = computerPlayer.getNumberList();
		userNumbers = userPlayer.getNumberList();

		countBall();
		if (ball == 0) {
			return Collections.emptyList();
		}

		countStrike();
		// strike 예외처리하기
		return List.of(ball, strike);

		/*initGameModel();*/

	}

	public void countBall() {
		for (int computerNumber : computerNumbers) {
			ball += Collections.frequency(userNumbers, computerNumber);
		}
	}

	public void countStrike() {
		for (int i=0; i<DIGIT_NUMBER.getCode(); i++) {
			if (computerNumbers.get(i).equals(userNumbers.get(i))) {
				strike++;
				ball--;
			}
		}
	}

	public void initGameModel() {
		ball = 0;
		strike = 0;
	}
}
