package baseball.model;

import baseball.util.GameCode;

public class Game {

    private Player player;
    private Judge judge;

    private int status;


    private Game() {
        this.player = new Player();
        this.judge = new Judge(player.defend());
        this.status = GameCode.PLAY.getValue();
    }

    public static Game start() {
        return new Game();
    }


}
