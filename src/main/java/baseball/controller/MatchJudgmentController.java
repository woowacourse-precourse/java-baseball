package baseball.controller;

import static baseball.GameRules.*;

import java.util.Collections;
import java.util.List;

import baseball.model.ComputerPlayer;
import baseball.model.UserPlayer;

public class MatchJudgmentController {
	private final ComputerPlayer computerPlayer;
	private final UserPlayer userPlayer = UserPlayer.getInstance();
	private List<Integer> computerNumbers;
	private List<Integer> userNumbers;
	private boolean gameOver = false;
	private int strike = 0;
	private int ball = 0;

	public MatchJudgmentController(ComputerPlayer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public List<Integer> getMatchResult() {
		computerNumbers = computerPlayer.getNumberList();
		userNumbers = userPlayer.getNumberList();

		initGameModel();
		countBall();
		if (ball == 0) {
			return Collections.emptyList();
		}

		countStrike();
		if (DIGIT_NUMBER.getCode().equals(strike)) {
			this.gameOver = true;
		}
		return List.of(ball, strike);
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
