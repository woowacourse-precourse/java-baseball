package baseball;

import static util.GameUtil.END;
import static util.GameUtil.GAME_END_MESSAGE;
import static util.GameUtil.GAME_RESTART_MESSAGE;
import static util.GameUtil.START;

import camp.nextstep.edu.missionutils.Console;

public class Restart {

	public static void answer(BaseballGame baseballGame) {
		System.out.println(GAME_RESTART_MESSAGE);
		String restartType = Console.readLine();

		if (restartType.equals(START)) {
			baseballGame.gameStart();
			answer(baseballGame);
		} else if (restartType.equals(END)) {
			System.out.println(GAME_END_MESSAGE);
		} else if (!restartType.equals(START) || !restartType.equals(END)) {
			answer(baseballGame);
		}
	}

}
