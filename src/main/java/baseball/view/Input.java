package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }
}
