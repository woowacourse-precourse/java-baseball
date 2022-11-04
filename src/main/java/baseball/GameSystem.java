package baseball;



public class GameSystem {
    Player player;
    Computer computer;
    ScoreBoard scoreBoard;


    public GameSystem() {
        this.player = new Player();
        this.computer = new Computer();
        this.scoreBoard = new ScoreBoard();
    }

}
