package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    User user;
    Computer computer;
    Judgement judgement;

    public GameController() {
        user = new User();
        computer = new Computer();
        judgement = new Judgement();
    }

    public void gameStart() {
        OutputView.printGameStartMessage();
        computer.generateRandomNumber();
        judgement.cntClear();

        while (judgement.getStrikeCnt() != 3) {
            String userInput = InputView.getUserInput();
            user.setUserInputNumber(userInput);
            if (judgement.isNothing(user, computer)) OutputView.printNothing();
            else OutputView.printBallAndStrike(judgement.getBallCnt(), judgement.getStrikeCnt());
        }

        OutputView.printGameEndMessage();
        gameRestartOrNot();
    }

    private void gameRestartOrNot() {
        String userInput = InputView.getUserInputRestartOrNot();
        if (userInput.equals("1")) gameStart();
    }
}
