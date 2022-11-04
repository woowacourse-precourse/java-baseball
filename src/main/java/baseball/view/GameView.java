package baseball.view;

import baseball.controller.GameController;
import baseball.model.Validation;
import baseball.controller.UserNumber;

import static baseball.model.Constant.*;
import static baseball.model.Utilization.convertStringToIntegerList;
import static baseball.view.GameView.UserInputValidation.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
    private final GameController gameController;

    public GameView() {
        gameController = new GameController();
        System.out.println(GAME_START_MESSAGE);
        gameController.generateComputerNumber();
    }

    public void run() {
        play();
        if (restart()) {
            gameController.refresh();
            run();
        }
    }

    private void play() {
        System.out.print(USER_NUMBER_INPUT_MESSAGE);
        generateUserNumber(inputUser());
        System.out.println(gameController
                .calculateHint()
                .toString());
        if (!gameController.isThreeStrike()) {
            play();
        }
        System.out.println(THREE_STRIKE_MESSAGE);
    }

    private boolean restart() {
        System.out.println(GAME_RESTART_OR_TERMINATE_MESSAGE);
        return restartOrTerminate(inputUser());
    }

    private String inputUser() {
        String userInput = readLine();
        if (!validateUserInput(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    private void generateUserNumber(String userInput) {
        if (!validateUserNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        gameController
                .setUserNumber(UserNumber
                        .generate(userInput));
    }

    private boolean restartOrTerminate(String userInput) {
        if (!validateRestartValue(userInput)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userInput) == GAME_RESTART_VALUE;
    }

    abstract static class UserInputValidation extends Validation {
        public static boolean validateUserInput(String userInput) {
            return validateNotNull(userInput)
                    && isInteger(userInput);
        }

        public static boolean validateUserNumber(String userInput) {
            return validateStringLength(userInput, NUMBER_LENGTH)
                    && validateEachUserNumberInRange(userInput)
                    && validateNumberNotRepeated(convertStringToIntegerList(userInput), NUMBER_LENGTH);
        }

        public static boolean validateRestartValue(String userInput) {
            return validateRestartValueInRange(userInput);
        }

        private static boolean validateEachUserNumberInRange(String userInput) {
            for (int number : convertStringToIntegerList(userInput)) {
                if (!validateIntegerRange(number, MIN_NUMBER_VALUE, MAX_NUMBER_VALUE))
                    return false;
            }
            return true;
        }

        private static boolean validateRestartValueInRange(String userInput) {
            return Integer.parseInt(userInput) == GAME_RESTART_VALUE
                    || Integer.parseInt(userInput) == GAME_TERMINATE_VALUE;
        }
    }
}
