package baseball.player;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private InputValidator validator = new InputValidator();

    public String sendAnswer() {
        String input = Console.readLine();
        validator.validateAnswer(input);
        System.out.println("숫자를 입력해주세요 : " + input);
        return input;
    }

    public String selectOptionAfterGameClear() {
        String input = Console.readLine();
        validator.validateRestartOption(input);
        return input;
    }
}
