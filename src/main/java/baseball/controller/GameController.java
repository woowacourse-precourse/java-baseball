package baseball.controller;

import baseball.model.BallCounts;
import baseball.util.Validation;
import baseball.view.Input;
import camp.nextstep.edu.missionutils.Console;

import baseball.model.Numbers;

public class GameController {
    private static final Validation validation = new Validation();
    private static final Input input = new Input();
    private static Numbers inputNumbers = new Numbers();
    private static BallCounts ballCounts = new BallCounts();

    public GameController() {
	System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void start() {
        Numbers answerNumbers = new Numbers();
        answerNumbers.createRandomNumbers();
        controlGameByResult(answerNumbers);
    }

    private static void controlGameByResult(Numbers answerNumbers) {
        BallCounts ballCounts = new BallCounts();
        try {
            do {
                input.inputGameNumber();
                setInputNumbers(Console.readLine());
                ballCounts.setBallCounts(answerNumbers.checkStrike(inputNumbers), answerNumbers.checkBall(inputNumbers));
            } while (ballCounts.getStrike() != 3);
            input.inputRestartNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("Error Message : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void setInputNumbers(String inputString) throws IllegalArgumentException {
        if (!validation.checkValidation(inputString)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        inputNumbers.setNumbers(inputString);
    }
}