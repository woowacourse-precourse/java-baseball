package inputoutput;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public void getPlayerNumber() {
        OutputManager.requestPlayerNumber();
        String playerNumber = Console.readLine();
    }
}
