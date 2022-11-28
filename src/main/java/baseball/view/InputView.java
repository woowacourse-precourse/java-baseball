package baseball.view;

import baseball.util.InputViewMessage;
import baseball.model.valid.GameCommandValidator;
import baseball.model.valid.InputValidator;
import baseball.model.valid.PlayerNumberValidator;
import camp.nextstep.edu.missionutils.Console;

public enum InputView {

    INSTANCE;

    public static String readPlayerNumber() {
        InputValidator inputValidator = new PlayerNumberValidator();
        System.out.print(InputViewMessage.READ_PLAYER_NUMBER_MESSAGE);

        return validInput(inputValidator);
    }

    public static String readGameCommand() {
        InputValidator inputValidator = new GameCommandValidator();
        System.out.println(InputViewMessage.READ_GAME_COMMAND_MESSAGE);

        return validInput(inputValidator);
    }

    private static String validInput(InputValidator inputValidator) {
        String input = Console.readLine();
        inputValidator.validate(input);
        return input;
    }
}
