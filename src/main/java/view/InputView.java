package view;

import camp.nextstep.edu.missionutils.Console;
import exceptions.GameCommandException;
import exceptions.SelectedNumbersException;

public class InputView {

    public static String getGamePlayerInput() {
        String playerNumbers = Console.readLine();
        SelectedNumbersException.validate(playerNumbers);
        return playerNumbers;
    }

    public static String getGameCommand() {
        String gameCommand = Console.readLine();
        GameCommandException.validate(gameCommand);
        return gameCommand;
    }
}
