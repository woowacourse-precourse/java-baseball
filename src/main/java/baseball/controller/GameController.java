package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judgement;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    User user = new User();
    Computer computer = new Computer();

    public void gameStart() {
        Judgement judgement = new Judgement();

        OutputView.printGameStartMessage();
        computer.generateRandomNumber();

        while (judgement.getStrikeCnt() != 3) {
            String userInput = InputView.getUserInput();
            user.setUserInputNumber(userInput);
            if (judgement.judgeNothing(user, computer)) OutputView.printNothing();
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
