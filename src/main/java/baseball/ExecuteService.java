package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ExecuteService {
    private Game game;
    private boolean complete;
    private static final PrintService printService = new PrintService();
    private final ProcessService processService = new ProcessService();

    public ExecuteService() {
        printService.gameStart();
    }

    public void execute() throws IllegalArgumentException {
        this.game = new Game();
        complete = false;

        while (!complete) {
            printService.requestInput();
            String userInput = getUserInput();
            processService.validateGameInput(userInput);

        }
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
