package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput implements GameState{

    @Override
    public String run() {
        String userInput = Console.readLine();
        return userInput;
    }
}
