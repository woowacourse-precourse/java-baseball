package baseball.game;

import baseball.domain.GameControlNum;
import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import baseball.opponent.Opponent;
import baseball.user.User;

public class BaseBallGame {

    private User user;
    private Opponent opponent;

    public BaseBallGame(User user, Opponent opponent) {
        this.user = user;
        this.opponent = opponent;
    }

    public static BaseBallGame makeBaseBallGame(User user, Opponent opponent) {
        return new BaseBallGame(user, opponent);
    }

    public void run() {
        user.readGameStartMsg();
        while(true) {
            ThreeDigitNum inputGuessedNum = user.inputGuessedNum();
            Hint hint = opponent.makeHint(inputGuessedNum);

            user.readHintMsg(hint);

            if(hint.isAnswer()) {
                user.readGameEndMsg();
                GameControlNum gameControlNum = user.inputGameControlNum();

                if(!gameControlNum.isRestart()) {
                    break;
                }

                this.opponent = Opponent.makeOpponent(opponent.getType());
            }
        }
    }
}
