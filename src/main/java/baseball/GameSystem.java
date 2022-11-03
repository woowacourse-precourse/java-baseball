package baseball;



public class GameSystem {
    BaseballNumber baseballNumber;
    Computer computer;
    ScoreBoard scoreBoard;


    public GameSystem() {
        baseballNumber = new BaseballNumber();
        computer = new Computer();
        scoreBoard = new ScoreBoard();
    }

}
