package baseball.system;

import baseball.player.Computer;
import baseball.player.Player;

public class Game {
    private Computer computer;
    private Player player;
    private int strikeCnt;
    private int ballCnt;

    public Game () {
        computer = new Computer();
        player = new Player();
        strikeCnt = 0;
        ballCnt = 0;
    }
}
