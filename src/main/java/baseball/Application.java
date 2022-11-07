package baseball;

import baseball.controller.NumberBaseballController;
import baseball.service.NumberBaseballService;
import baseball.validation.UserInputValidator;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        NumberBaseballService numberBaseballService = new NumberBaseballService();
        ConsoleView consoleView = new ConsoleView();
        UserInputValidator userInputValidator = new UserInputValidator();

        NumberBaseballController numberBaseballController = new NumberBaseballController(
                userInputValidator,
                numberBaseballService,
                consoleView
        );

        numberBaseballController.playNumberBaseball();
    }
}
