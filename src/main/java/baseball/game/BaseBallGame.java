package baseball.game;

import baseball.domain.Hint;
import baseball.domain.GameControlStatus;
import baseball.opponent.Opponent;
import baseball.user.User;

public class BaseBallGame {

    private User user;
    private Opponent opponent;
    private GameControlStatus gameControlStatus;

    public BaseBallGame(User user, Opponent opponent) {
        this.user = user;
        this.opponent = opponent;
        this.gameControlStatus = null;
    }

    public static BaseBallGame makeBaseBallGame(User user, Opponent opponent) {
        return new BaseBallGame(user, opponent);
    }

    public void run() {
        user.readGameStartMsg();

        while (!(isGameStop())) {
            Hint hint = opponent.makeHint(user.inputGuessedNum());

            user.readHintMsg(hint);

            updateGameStatusBy(hint);
        }
    }

    private void updateGameStatusBy(Hint hint) {
        if (!hint.isAnswer()) {
            return;
        }

        user.readGameCompleteMsg();

        updateGameStatus();
        changeOpponent();
    }

    private boolean isGameStop() {
        return gameControlStatus != null && gameControlStatus.isStop();
    }

    private void updateGameStatus() {
        this.gameControlStatus = user.inputGameControlNum();

    }

    private void changeOpponent() {
        if (isGameStop()) {
            return;
        }
        this.opponent = Opponent.makeOpponent(opponent.getType());
    }
}
