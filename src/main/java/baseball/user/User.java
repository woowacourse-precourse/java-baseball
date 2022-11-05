package baseball.user;

import baseball.domain.GameControlNum;
import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import baseball.io.InputControl;
import baseball.io.OutputControl;

public class User {

    public User() {
    }

    public ThreeDigitNum inputGuessedNum() {
        OutputControl.println("숫자를 입력해주세요 : ");
        return new ThreeDigitNum((InputControl.readInt()));
    }

    public GameControlNum inputGameControlNum() {
        OutputControl.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return new GameControlNum((InputControl.readInt()));
    }

    public void readGameStartMsg() {
        OutputControl.println("숫자 야구 게임을 시작합니다.");
    }
    public void readGameEndMsg() {
        OutputControl.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void readHintMsg(Hint hint) {
        OutputControl.println(hint.toString());
    }


}
