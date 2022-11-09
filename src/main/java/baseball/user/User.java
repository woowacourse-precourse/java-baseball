package baseball.user;

import baseball.domain.GameControlStatus;
import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import baseball.enums.GameMessage;
import baseball.io.InputControl;
import baseball.io.OutputControl;

public class User {


    public User() {
    }

    static public User makeUser() {
        return new User();
    }

    public ThreeDigitNum inputGuessedNum() {
        OutputControl.println(GameMessage.INPUT_NUMBER.value());
        return new ThreeDigitNum((InputControl.readInt()));
    }

    public GameControlStatus inputGameControlNum() {
        OutputControl.println(GameMessage.GAME_RESTART.value());
        return new GameControlStatus((InputControl.readInt()));
    }

    public void readGameStartMsg() {
        OutputControl.println(GameMessage.GAME_START.value());
    }
    public void readGameCompleteMsg() {
        OutputControl.println(GameMessage.GAME_COMPLETE.value());
    }
    public void readHintMsg(Hint hint) {
        OutputControl.println(hint.toString());
    }


}
