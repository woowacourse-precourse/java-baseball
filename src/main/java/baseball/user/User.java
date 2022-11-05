package baseball.user;

import baseball.domain.GameControlStatus;
import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import baseball.io.InputControl;
import baseball.io.OutputControl;

public class User {

    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public User() {
    }

    static public User makeUser() {
        return new User();
    }

    public ThreeDigitNum inputGuessedNum() {
        OutputControl.println(INPUT_NUMBER_MESSAGE);
        return new ThreeDigitNum((InputControl.readInt()));
    }

    public GameControlStatus inputGameControlNum() {
        OutputControl.println(GAME_RESTART_MESSAGE);
        return new GameControlStatus((InputControl.readInt()));
    }

    public void readGameStartMsg() {
        OutputControl.println(GAME_START_MESSAGE);
    }
    public void readGameCompleteMsg() {
        OutputControl.println(GAME_COMPLETE_MESSAGE);
    }
    public void readHintMsg(Hint hint) {
        OutputControl.println(hint.toString());
    }


}
