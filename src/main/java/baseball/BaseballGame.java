package baseball;

public class BaseballGame {

	public BaseballGame() {
		Console.startMessage();
	}

	public void gameStart() {
		Computer computerBalls = new Computer();
		BaseballUmpire baseballUmpire = new BaseballUmpire();
		String userBalls = Console.inputUserBalls();

		while (baseballUmpire.refereeBalls(userBalls, computerBalls.getComputerBalls())) {
			baseballUmpire = new BaseballUmpire();
			userBalls = Console.inputUserBalls();
		}
	}

}
