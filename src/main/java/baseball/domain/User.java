package baseball.domain;

import baseball.validate.UserValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자를 맞추는 유저 클래스
 */
public class User {
    private static final int RESTART = 1;
    private static final int FINISH = 2;
    private String number;
    private UserValidator validator = new UserValidator();

    public void inputNumber() {
        this.number = Console.readLine();
    }

    public void validateNumber() {
        validator.validateNumber(number);
    }

    public void validateRestart() {
        validator.validateRestart(number);
    }

    public boolean isStop() {
        int restartChoice = Integer.parseInt(number);

        if (restartChoice == FINISH) {
            return true;
        } else if (restartChoice == RESTART) {
            return false;
        }

        return true;
    }

    public String getNumber() {
        return number;
    }

}
