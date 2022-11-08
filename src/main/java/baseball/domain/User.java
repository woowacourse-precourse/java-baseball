package baseball.domain;

import baseball.validate.UserValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자를 맞추는 유저 클래스
 */
public class User {
    private String number;
    private UserValidator validator = new UserValidator();

    public void inputNumber() {
        this.number = Console.readLine();
    }

    public void validateNumber() {
        validator.validateNumber(number);
    }

    public String getNumber() {
        return number;
    }

}
