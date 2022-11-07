package baseball;

import static baseball.BaseballGameManager.NUMBER_COUNT_TO_CREATED;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private BaseballGameManager gameManager = new BaseballGameManager();

    public void start() {
        gameManager.createRandomNumbers();
        do {
            String input = inputAnswer();
            isWrongInputValue(input);
            gameManager.printResult(input);
        } while ((!gameManager.isGameClear()));

    }

    private String inputAnswer() {
        String input = Console.readLine();
        System.out.println("숫자를 입력해주세요 : " + input);
        return input;
    }

    private void isWrongInputValue(String input) {
        if (input.length() != NUMBER_COUNT_TO_CREATED) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
