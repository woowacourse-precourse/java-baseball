package baseball.controller;

import baseball.model.BallCounts;
import baseball.util.Validation;
import baseball.view.Input;
import baseball.view.Output;
import baseball.model.Numbers;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final Validation validation = new Validation();
    private static final Input inputView = new Input();
    private static final Output outputView = new Output();
    private Numbers inputNumbers = new Numbers();
    private BallCounts ballCounts = new BallCounts();

    public GameController() {
        outputView.outputStart();
    }

    public void start() {
        Numbers answerNumbers = new Numbers();
        answerNumbers.createRandomNumbers();
        controlGameByResult(answerNumbers);
    }

    private void controlGameByResult(Numbers answerNumbers) {
        do {
            inputView.inputGameNumber();
            setInputNumbers(answerNumbers);
            outputView.outputBallCounts(ballCounts);
        } while (ballCounts.getStrike() != 3);

        outputView.outputRestart();
        inputView.inputRestartNumber();
    }

    private void setInputNumbers(Numbers answerNumbers) throws IllegalArgumentException {
        String inputString = Console.readLine();

        if (!validation.checkValidation(inputString)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        inputNumbers.setNumbers(inputString);
        ballCounts.setBallCounts(answerNumbers, inputNumbers);
    }
}