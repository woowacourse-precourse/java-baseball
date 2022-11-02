package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.User;
import baseball.view.InputView;

public class GameController {
    User user = new User();
    Computer computer = new Computer();
    Judgement judgement = new Judgement();

    public void gameStart() {
        computer.generateRandomNumber();

        while (true) {
            String userInput = InputView.getUserInput();
            user.setUserInputNumber(userInput);

        }
    }
}
