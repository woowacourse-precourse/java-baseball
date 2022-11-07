package baseball.controller;

import baseball.message.GameProgressMessage;
import baseball.service.ProgressService;
import baseball.validation.NumberValidation;
import camp.nextstep.edu.missionutils.Console;

import static baseball.message.GameProgressMessage.*;

public class BullsAndCows {

    private final ProgressService progressService;
    private final NumberValidation validation;

    public BullsAndCows() {
        progressService = new ProgressService();
        validation = new NumberValidation();
    }

    public void playGame() {

        while (!progressService.isEnd()) {
            System.out.println(PROGRESS_MESSAGE);
            String userInput = Console.readLine();
            validation.validateUserInput(userInput);

            String message = progressService.getResultMessageOfGuessNumber(userInput);
            System.out.println(message);
        }

        System.out.println(ASK_QUIT);

        String userInput = Console.readLine();

        GameProgressMessage resultOfEndGame = progressService.getResultOfEndGame(userInput);

        if (resultOfEndGame.equals(RESTART)) {
            System.out.println(RESTART);
            restart();
        }

        if (resultOfEndGame.equals(END)) {
            System.out.println(END);
        }
    }

    private void restart() {
        progressService.initProgress();
        playGame();
    }

}
