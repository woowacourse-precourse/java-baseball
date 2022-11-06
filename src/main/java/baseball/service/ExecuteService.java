package baseball.service;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ExecuteService {
    private final PrintService printService = new PrintService();
    private final ProcessService processService = new ProcessService();

    public ExecuteService() {
        printService.gameStart();
    }

    public void execute() throws IllegalArgumentException {
        Game game = new Game();
        boolean complete = false;
        List<Integer> answer = game.getAnswer();

        while (!complete) {
            printService.requestInput();
            String userInput = getUserInput();

            processService.validateGameInput(userInput);
            List<Integer> parsedInput = processService.parseGameInput(userInput);

            List<Integer> strikeBallCount = processService.compare(parsedInput, answer);
            printService.printStrikeBallResult(strikeBallCount);
            complete = checkCompleteness(strikeBallCount.get(0));
        }

        printService.printGameEnd();
        String endInput = getUserInput();
        processService.validateEndInput(endInput);
        int parsedEndInput = Integer.parseInt(endInput);

        if (parsedEndInput == 1) {
            execute();
        }
    }

    private boolean checkCompleteness(Integer strikes) {
        return strikes == 3;
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
