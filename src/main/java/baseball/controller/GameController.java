package baseball.controller;

import baseball.model.User;
import baseball.view.InputView;

public class GameController {
    User user = new User();

    public void gameStart() {
        String userInput = InputView.getUserInput();
        user.setUserInputNumber(userInput);
    }
}
