package baseball.domain;

import java.util.List;

import baseball.view.InputView;
import baseball.view.PrintView;

public class Game {
	private final Computer computer;
	private User user;
	private int ball;
	private int strike;

	public Game() {
		computer = new Computer();
	}

	public void play() {
		PrintView.printStartMessage();
		computer.createAnswer();
		tryCorrectAnswer();
	}

	private void tryCorrectAnswer() {
		initBallAndStrike();
		user = new User(InputView.inputNum());

		compareNumber(computer.getAnswer(), user.getNumber());
		PrintView.printHint(ball, strike);

		if (isCorrectAnswer()) {
			endGame();
		} else {
			tryCorrectAnswer();
		}
	}

	private void endGame() {
		PrintView.printEndGame();

		if(InputView.inputRestartOrEnd().equals(InputView.RESTART_NUM)){
			play();
		}
	}

	private boolean isCorrectAnswer() {
		if (strike == Computer.ANSWER_LENGTH) {
			return true;
		} else {
			return false;
		}
	}

	private void initBallAndStrike() {
		ball = 0;
		strike = 0;
	}

	private void compareNumber(List<Integer> answer, List<Integer> number) {
		for (int index = 0; index < number.size(); index++) {
			countBallAndStrike(answer, number, index);
		}
	}

	private void countBallAndStrike(List<Integer> answer, List<Integer> number, int index) {
		if (answer.get(index).equals(number.get(index))) {
			strike++;
		} else if (answer.contains(number.get(index))) {
			ball++;
		}
	}

}
