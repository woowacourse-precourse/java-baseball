package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getGamePlayerInput() {
        String playerNumbers = Console.readLine();
        verifyPlayerNumbers(playerNumbers);
        return playerNumbers;
    }

    public static void verifyPlayerNumbers(String playerNumbers) {

    }

    public static String getGameCommand() {
        return Console.readLine();
    }
}
