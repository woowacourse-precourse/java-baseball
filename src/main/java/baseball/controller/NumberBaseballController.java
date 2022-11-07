package baseball.controller;

import baseball.dto.StrikeBallCountDto;
import baseball.service.NumberBaseballService;
import baseball.validation.UserInputValidator;
import baseball.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballController {

    private final UserInputValidator validator;
    private final NumberBaseballService numberBaseballService;
    private final ConsoleView consoleView;

    public NumberBaseballController(UserInputValidator validator, NumberBaseballService numberBaseballService, ConsoleView consoleView) {
        this.validator = validator;
        this.numberBaseballService = numberBaseballService;
        this.consoleView = consoleView;
    }

    public void playNumberBaseball() {
        boolean isPlaying = true;

        while (isPlaying) {
            consoleView.printInputMessage();
            int input = readUserInput();

            StrikeBallCountDto strikeBallCountDto = numberBaseballService.compareInputAndAnswer(input);
            consoleView.printStrikeBallCount(strikeBallCountDto);

            if (strikeBallCountDto.getStrikeCount() == 3) {
                consoleView.printSuccessMessage();
                consoleView.printRestartMessage();
                input = readRestartInput();
            }

            if (input == 1) {
                numberBaseballService.initAnswerNumber();
            } else if (input == 2) {
                isPlaying = false;
            }
        }
    }

    private int readUserInput() {
        String input = Console.readLine();

        validator.validateGuessInput(input);

        return Integer.parseInt(input);
    }

    private int readRestartInput() {
        String input = Console.readLine();

        validator.validateRestartInput(input);

        return Integer.parseInt(input);
    }
}
