package baseball;

public class BaseballGame {
    private Rival computer;

    BaseballGame(){
        computer = new Rival();
    }

    public void play(){
        computer.createNumber();
    }

}
