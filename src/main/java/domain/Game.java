package domain;

public class Game {
    private BaseballNumbers computerNumbers;

    public void startGame(){
        this.computerNumbers = BaseballNumbers.getComputerNumbers();
    }
}
