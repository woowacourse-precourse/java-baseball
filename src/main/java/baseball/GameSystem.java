package baseball;



public class GameSystem {
    Player player;
    Computer computer;
    ScoreBoard scoreBoard;


    public GameSystem() {
        player = new Player();
        computer = new Computer();
        scoreBoard = new ScoreBoard();
    }

}
