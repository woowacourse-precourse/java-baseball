package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int STRIKE = 0;
	private static final int BALL = 1;
	private static final Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	public int play(PlayerComputer computer, PlayerUser user) {
		int numberOfStrike;

		String answer = computer.getRandomNumber();
		do {
			String userInput = user.getInputNumber();
			List<Integer> judgement = compareUserInputToAnswer(userInput, answer);
			printMessage(judgement);
			numberOfStrike = judgement.get(STRIKE);
		} while (!isCorrectAnswer(numberOfStrike));
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

		return askReplay();
	}

	private List<Integer> compareUserInputToAnswer(String userInput, String answer) {
		List<Integer> judgement = new ArrayList<>();
		int userNumberLength = userInput.length();
		int strikes = 0, balls = 0;

		for (int i = 0; i < userNumberLength; i++) {
			char userDigit = userInput.charAt(i);
			char answerDigit = answer.charAt(i);

			strikes += countStrikes(userDigit, answerDigit);
			balls += countBalls(userDigit, answerDigit, answer);
		}

		judgement.add(strikes);
		judgement.add(balls);
		return judgement;
	}

	private void printMessage(List<Integer> judgement) {
		String msg = generateMessage(judgement);
		System.out.println(msg);
	}

	private boolean isCorrectAnswer(int numberOfStrike) {
		return numberOfStrike == 3;
	}

	private int askReplay() {
		String input;
		int replayOrEndgame;

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		try {
			input = Console.readLine();
			replayOrEndgame = Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			// System.out.println("거 제대로 좀 입력합시다! 네? 아시겠어요? 아시겠냐구요?!?!");
			throw new IllegalArgumentException();
		}
		return replayOrEndgame;
	}

	private int countStrikes(char userDigit, char answerDigit) {
		if (userDigit == answerDigit) {
			return 1;
		}
		return 0;
	}

	private int countBalls(char userDigit, char answerDigit, String answer) {
		String userDigitToString = String.valueOf(userDigit);

		if (userDigit != answerDigit && answer.contains(userDigitToString)) {
			return 1;
		}
		return 0;
	}

	private String generateMessage(List<Integer> judgement) {
		int strikeCounter = judgement.get(STRIKE);
		int ballCounter = judgement.get(BALL);

		if (isNothing(strikeCounter, ballCounter)) {
			return "낫싱";
		}
		if (strikeCounter == 0) {
			return ballCounter + "볼";
		}
		if (ballCounter == 0) {
			return strikeCounter + "스트라이크";
		}
		return ballCounter + "볼" + " " + strikeCounter + "스트라이크";
	}

	private boolean isNothing(int strikeCounter, int ballCounter) {
		return strikeCounter == 0 && ballCounter == 0;
	}
}
