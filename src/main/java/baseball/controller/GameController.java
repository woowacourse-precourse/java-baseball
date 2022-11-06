package baseball.controller;

import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

import baseball.model.Numbers;

public class GameController {
    private static final Validation validation = new Validation();
    private static Numbers inputNumbers = new Numbers();

    public GameController() {
	System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void start() {
        Numbers answerNumbers = new Numbers();
        answerNumbers.createRandomNumbers();
        controlGameByResult(answerNumbers);
    }

    private static void controlGameByResult(Numbers answerNumbers) {
        try {
            do {
                setInputNumbers(Console.readLine());
            } while (answerNumbers.checkStrike(inputNumbers) != 3);
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