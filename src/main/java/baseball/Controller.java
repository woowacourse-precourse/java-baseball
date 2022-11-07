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

}