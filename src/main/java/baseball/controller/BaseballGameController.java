package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameController {

    public void gameStart() {
        GameScreen.printGameStart();
        GameScreen.printUserInput();

        String playerInputNumbers = Console.readLine();
    }
}
