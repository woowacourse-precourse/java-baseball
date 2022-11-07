package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUTMESSAGE = "숫자를 입력해주세요 : ";

    public String suggestNumber() {
        System.out.print(INPUTMESSAGE);
        String number = Console.readLine();

        return number;

    }
}
