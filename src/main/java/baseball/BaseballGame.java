package baseball;

import java.util.List;

import static utils.PlayerAdditionalGameInputUtil.readAdditionalGameQuestion;
import static utils.PlayerBallsInputUtil.readBalls;
import static baseball.BaseballGameConstants.*;

public class BaseballGame {

	private Computer computer;
	private Player player;
	private Referee referee;

	private List<Integer> playerBalls;
	private List<Integer> computerBalls;
	private boolean firstRound;

	public BaseballGame(Computer computer, Player player, Referee referee) {
		this.computer = computer;
		this.player = player;
		this.referee = referee;
		firstRound = true;
	}

	public void gameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		int gameState = ING;
		
		while (true) {

			if (firstRound) {
				computer.pitchThreeUniqueBalls();
				computerBalls = computer.getComputerBalls();
				firstRound = false;
			}

			System.out.print("숫자를 입력해주세요 : ");
			player.pitchThreeUniqueBalls(readBalls());
			playerBalls = player.getPlayerBalls();

			String gameResult = referee.judge(computerBalls, playerBalls);
			System.out.println(gameResult);

			if (gameResult.equals(endGameResult)) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				gameState = decideAdditionalGame();
			}

			if (gameState == NO_ADDITIONAL_GAME) {
				break;
			}

			if (gameState == ADDITIONAL_GAME) {
				firstRound = true;
				gameState = ING;
				System.out.println("게임 재시작");
			}
		}
	}

	private int decideAdditionalGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String nextGameState = readAdditionalGameQuestion();
		
		if (nextGameState.equals("1")) {
			return ADDITIONAL_GAME;
		}
		return NO_ADDITIONAL_GAME;
	}
}