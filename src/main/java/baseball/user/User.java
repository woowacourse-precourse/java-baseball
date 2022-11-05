package baseball.user;

import baseball.domain.GameControlNum;
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

    public GameControlNum inputGameControlNum() {
        OutputControl.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return new GameControlNum((InputControl.inputInt()));
    }

}
