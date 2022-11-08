package baseball.controller.judge;

import baseball.domain.user.Opponent;
import baseball.domain.user.Player;

public interface Judge {
    boolean judgement(Player player, Opponent opponent);
    void showHint(int strike, int ball);
}
