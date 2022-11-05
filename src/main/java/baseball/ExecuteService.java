package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ExecuteService {
    private Game game;
    private boolean complete;
    private static final PrintService printService = new PrintService();

    public ExecuteService() {
        printService.gameStart();
    }

    public void execute() {
        this.game = new Game();
        complete = false;

        while (!complete) {
            printService.requestInput();
            String userInput = getUserInput();
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
