package baseball.service;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.domain.StrikeAndBall;
import baseball.util.RandomUtil;
import baseball.view.GameMessage;
import baseball.view.RequestPlayerInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int NUMBER_LENGTH = 3;
	private static final int MAX_STRIKE_COUNT = 3;

	Player player;
	Opponent opponent;
	StrikeAndBall strikeAndBall;

	public Game() {

	}

	public Game(Player player, Opponent opponent, StrikeAndBall strikeAndBall) {
		this.player = player;
		this.opponent = opponent;
		this.strikeAndBall = strikeAndBall;
	}

	public void prepareGame() {
		opponent = new Opponent(List.copyOf(RandomUtil.getRandomUniqueNumbers(START_NUMBER, END_NUMBER, NUMBER_LENGTH)));
		player = new Player(List.of(0, 0, 0));
		strikeAndBall = new StrikeAndBall(0, 0);
	}

	public void playGame() {
		List<Integer> playerInputNumbers;

		GameMessage.printStartMessage();

		while(strikeAndBall.getStrike() != MAX_STRIKE_COUNT) {
			strikeAndBall.setStrike(0);
			strikeAndBall.setBall(0);

			playerInputNumbers = getPlayerInput();
			player.setPlayerNumbers(playerInputNumbers);

			judgeStrikeAndBallCount();

			GameMessage.printResultOfInput(strikeAndBall.getStrike(), strikeAndBall.getBall());
		}
	}

	private List<Integer> getPlayerInput() {
		RequestPlayerInput.requestInputPlayerNumbers();
		String[] playerInputs = Console.readLine().split("");

		checkInput(playerInputs);

		List<Integer> playerInputNumbers = Arrays.stream(playerInputs).map(Integer::parseInt).collect(Collectors.toList());

		return playerInputNumbers;
	}

	protected void checkInput(String[] playerInputs) {
		if (playerInputs.length != 3) {
			throw new IllegalArgumentException();
		}
		if (new HashSet<>(List.of(playerInputs)).size() != 3) {
			throw new IllegalArgumentException();
		}
		for (String playerInput : playerInputs) {
			if (!Character.isDigit(playerInput.charAt(0)) || playerInput.equals("0")) {
				throw new IllegalArgumentException();
			}
		}
	}

	protected void judgeStrikeAndBallCount() {
		for (int i = 0;i < NUMBER_LENGTH; i++) {
			judgeStrikeAndBall(i, opponent.getAnswerNumbers(), player.getPlayerNumbers());
		}
	}

	private void judgeStrikeAndBall(int position, List<Integer> opponentNumbers, List<Integer> playerNumbers) {
		int strike = 0;
		int ball = 0;

		for (int i = 0;i <opponentNumbers.size(); i++) {
			if (playerNumbers.get(position) == opponentNumbers.get(i)) {
				strike += judgeStrike(position, i);
				ball += judgeBall(position, i);
			}
		}

		strikeAndBall.setStrike(strikeAndBall.getStrike() + strike);
		strikeAndBall.setBall(strikeAndBall.getBall() + ball);
	}

	private int judgeStrike(int position1, int position2) {
		if (position1 == position2) {
			return 1;
		}
		return 0;
	}

	private int judgeBall(int position1, int position2) {
		if (position1 != position2) {
			return 1;
		}
		return 0;
	}

	public void endGame() {
		GameMessage.printEndMessage();
	}
}
