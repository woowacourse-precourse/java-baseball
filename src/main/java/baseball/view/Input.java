package baseball.view;

import baseball.domain.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Validator validator;

    private static final String INPUTMESSAGE = "숫자를 입력해주세요 : ";

    private static final String RESTARTMESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public Input(Validator validator) {
        this.validator = validator;
    }

    public String suggestNumber() {
        System.out.print(INPUTMESSAGE);
        String number = Console.readLine();

        validator.isValidate(number);
        return number;
    }

    public String continueOrNot() {
        System.out.println(RESTARTMESSAGE);
        String restartMessage = Console.readLine();

        validator.restartValidate(restartMessage);
        return restartMessage;
    }
}