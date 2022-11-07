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
	System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        Numbers answerNumbers = new Numbers();
        answerNumbers.createRandomNumbers();
        controlGameByResult(answerNumbers);
    }

    private void controlGameByResult(Numbers answerNumbers) {
        try {
            do {
                inputView.inputGameNumber();
                setInputNumbers(Console.readLine());
                ballCounts.setBallCounts(answerNumbers, inputNumbers);

            } while (ballCounts.getStrike() != 3);
            outputView.outputRestart();
            inputView.inputRestartNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("Error Message : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setInputNumbers(String inputString) throws IllegalArgumentException {
        if (!validation.checkValidation(inputString)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        inputNumbers.setNumbers(inputString);
    }
}