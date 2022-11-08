package baseball.controller.ground;

import baseball.controller.judge.BaseballJudge;
import baseball.controller.judge.Judge;
import baseball.domain.user.Opponent;
import baseball.domain.user.Player;

public class PlayGround {
    private final Player player;
    private final Opponent opponent;
    private final Judge judge;
    private boolean isPlaying = true;

    public PlayGround() {
        player = new Player();
        opponent = new Opponent();
        judge = new BaseballJudge();
    }

    public void playInGround() {
        while (isPlaying) {
            player.enterNumberList();
            isPlaying = !judge.judgement(player, opponent);
        }
    }
}
