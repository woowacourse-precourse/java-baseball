package baseball;

import baseball.service.GameService;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
	GameService service = new GameService();
	SystemMessage systamMassage = new SystemMessage();

	public void run() {
		computerSetting();
		startGame();
		endMassage();
		retryGame(Integer.parseInt(Console.readLine()));
	}

	public void computerSetting() {
		service.ramdomNumberSetting();
	}

	public void startGame() {
		service.playGame();
	}

	public void endMassage() {
		System.out.println(systamMassage.PrintGoal());
	}

	public void retryGame(int number) throws IllegalArgumentException {
		if (number != 1 && number != 2) {
			throw new IllegalArgumentException();
		}

		if (number == 1) {
			service.computerReset();
			run();
		}
	}

}