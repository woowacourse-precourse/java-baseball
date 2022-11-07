package baseball.game;

import baseball.domain.Hint;
import baseball.domain.GameControlStatus;
import baseball.opponent.Opponent;
import baseball.user.User;

public class BaseBallGame {

    private User user;
    private Opponent opponent;
    private GameControlStatus status;

    public BaseBallGame(User user, Opponent opponent) {
        this.user = user;
        this.opponent = opponent;
        this.status = null;
    }

    public static BaseBallGame makeBaseBallGame(User user, Opponent opponent) {
        return new BaseBallGame(user, opponent);
    }

    public void run() {
        user.readGameStartMsg();

        while (!(isGameStop())) {
            playTurn();
        }
    }

    private void playTurn() {
        Hint hint = opponent.makeHint(user.inputGuessedNum());

        user.readHintMsg(hint);

        updateStatusFor(hint);
    }

    private void updateStatusFor(Hint hint) {
        if (!hint.isAnswer()) {
            return;
        }

        user.readGameCompleteMsg();

        updateStatus();
        changeOpponent();
    }

    private boolean isGameStop() {
        return status != null && status.isStop();
    }

    private void updateStatus() {
        this.status = user.inputGameControlNum();

    }

    private void changeOpponent() {
        if (isGameStop()) {
            return;
        }
        this.opponent = Opponent.makeOpponent(opponent.getType());
    }
}
