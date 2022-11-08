package baseball.controller;

import baseball.domain.GameService;
import baseball.domain.model.Result;
import baseball.domain.model.UserInput;
import baseball.domain.model.request.UserInputRequest;
import baseball.view.RestartView;
import baseball.view.ResultPrintView;
import baseball.view.UserInputView;

public class GameController {

    private static UserInputView userInputView = new UserInputView();
    private static ResultPrintView resultPrintView = new ResultPrintView();
    public static RestartView restartView = new RestartView();
    private static GameService gameService;

    public void run() {
        userInputView.openingText();
        do {
            gameService = new GameService();
            this.process();
        } while (restartView.doseUserWantMoreGame());
    }

    public void process() {
        Result result;
        do {
            UserInputRequest settingRequest = userInputView.generateUserInputRequest();
            UserInput userInput = new UserInput(settingRequest);
            result = gameService.getResult(userInput);
            resultPrintView.printResult(result);
        } while (!result.isOut());
    }
}
