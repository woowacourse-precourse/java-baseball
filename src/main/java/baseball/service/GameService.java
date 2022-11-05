package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;

public class GameService {

    Player player;
    Computer computer;
    private int strikeCount;
    private int ballCount;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void initializeScore(){
        strikeCount = 0;
        ballCount = 0;
    }

    public void checkComputerWithPlayerNumber(){

    }

    public List<Integer> getPlayerNumbers(){
        return player.getNumbers();
    }

    public List<Integer> getComputersNumbers(){
        return computer.getNumbers();
    }

    public void scoreGameWithIndex(int index){

    }

    public boolean isStrike(int index){
        return false;
    }

    public boolean isBall(int index){
        return false;
    }

    public void increaseStrike(){

    }

    public void increaseBall(){

    }
}
