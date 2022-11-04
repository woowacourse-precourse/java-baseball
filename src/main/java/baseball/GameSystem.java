package baseball;



public class GameSystem {
    static final int WIN_STRIKE_COUNT = 3;
    private Player player;
    private Computer computer;
    private ScoreBoard scoreBoard;



    public GameSystem() {
        this.player = new Player();
        this.computer = new Computer();
        this.scoreBoard = new ScoreBoard();
    }

}
