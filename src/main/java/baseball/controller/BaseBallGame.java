package controller;

import baseball.domain.GameLogic;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.view.InputView.getPlayerRandomNumbers;

public class BaseBallGame {
    private RandomNumbers computerNumbers;

    private void getRandomNumbers() {
        computerNumbers = new RandomNumbers();
    }

    public void startGame() {
        getRandomNumbers();
        Boolean play = true;
        OutputView.printStartMessage();
        do {
            List<Integer> playerNumbers = getPlayerRandomNumbers();
            GameLogic result = new GameLogic(computerNumbers, playerNumbers);
            OutputView.printResult(result);
            if (result.equals("3스트라이크")) {
                OutputView.printSuccessMessage();
                play = InputView.restartOrEndGame();
            }
        } while (play);
    }



}
