package baseball.user;

import baseball.domain.ThreeDigitNum;
import baseball.io.InputControl;
import baseball.io.OutputControl;

public class User {

    public User() {
    }

    public ThreeDigitNum inputGuessedNum() {
        OutputControl.println("숫자를 입력해주세요 : ");
        return new ThreeDigitNum((InputControl.inputInt()));
    }

    public ThreeDigitNum inputGu2essedNum() {
        OutputControl.println("숫자를 입력해주세요 : ");
        return new ThreeDigitNum((InputControl.inputInt()));
    }

}
