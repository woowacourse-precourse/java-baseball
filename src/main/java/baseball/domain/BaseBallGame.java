package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

	private static final String RESTART_OPTION = "1";
	private static final String QUIT_OPTION = "2";

	private Referee referee;
	private Balls computerBalls;
	private Balls playerBalls;
	private boolean doContinue;

	public BaseBallGame() {
		init();
	}

	private void init() {
		this.referee = new Referee();
	}

	public void play() {
		printStartMessage();
		doContinue = true;
		while (doContinue) {
			playGame();
		}
	}

	private void printStartMessage() {
		System.out.println(Constants.START_MSG);
	}

	private void playGame() {
		setComputerBalls();
		boolean isEnd = false;
		while (!isEnd) {
			inputBalls();
			PlayResult playResult = referee.judge(playerBalls, computerBalls);
			printResult(playResult);
			isEnd = playResult.isEnd();
		}
		printEndMessage();
		printRestartMessage();
		inputRestartOption();
	}

	private void setComputerBalls() {
		this.computerBalls = new Balls(RandomGenerator.generateNumbers());
	}

	private void inputBalls() {
		System.out.print(Constants.INPUT_BALLS_MSG);
		String inputBalls = Console.readLine();
		this.playerBalls = new Balls(inputBalls);
	}

	private void printResult(PlayResult playResult) {
		System.out.println(playResult.toString());
	}

	private void printEndMessage() {
		System.out.println(Constants.END_MSG);
	}

	private void printRestartMessage() {
		System.out.println(Constants.INPUT_RESTART_MSG);
	}

	private void inputRestartOption() {
		String selectOption = Console.readLine();
		if (selectOption.equals(QUIT_OPTION)) {
			doContinue = false;
			return;
		}
		if (!selectOption.equals(RESTART_OPTION)) {
			throw new IllegalArgumentException("1, 2 만 입력할 수 있습니다.");
		}
	}
}
