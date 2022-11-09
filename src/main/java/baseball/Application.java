package baseball;

import static baseball.game.BaseBallGame.makeBaseBallGame;
import static baseball.user.User.makeUser;

import baseball.opponent.Opponent;

public class Application {
    public static void main(String[] args) {
        makeBaseBallGame(makeUser(), Opponent.makeOpponent(Opponent.COMPUTER_OPPONENT)).run();
    }
}
