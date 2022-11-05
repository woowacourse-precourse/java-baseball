package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ExecuteService {
    private Game game;
    private boolean complete;

    public void execute() {
        this.game = new Game();
        complete = false;

        while (!complete) {
            String userInput = getUserInput();
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
