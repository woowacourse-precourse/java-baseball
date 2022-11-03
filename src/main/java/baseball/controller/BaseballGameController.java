package baseball.controller;

import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    public void gameStart() {
        GameScreen.printGameStart();
        GameScreen.printUserInput();

        String playerInputNumbers = Console.readLine();
    }
}
