package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final Validator validator = new Validator();

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!validator.isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
    public String inputExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!validator.isRightNumber(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
