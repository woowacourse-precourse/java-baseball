package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static String getUserInput() {
        GameOutput.printUserInputMessage();
        String userInput = Console.readLine();
        return userInput;
    }

    public static String getUserRestartInput(){
        GameOutput.printRestartGame();
        String userRestartInput = Console.readLine();
        return userRestartInput;
    }
}
