package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private BaseballGameManager gameManager = new BaseballGameManager();
    private InputValidator validator = new InputValidator();

    public void play() {
        gameManager.createRandomNumbers();
        do {
            gameManager.provideResult(sendAnswer());
        } while ((!gameManager.isGameClear()));
    }

    public String selectOptionAfterGameClear() {
        String input = Console.readLine();
        validator.validateRestartOption(input);
        return input;
    }

    private String sendAnswer() {
        String input = Console.readLine();
        validator.validateAnswer(input);
        System.out.println("숫자를 입력해주세요 : " + input);
        return input;
    }
}
