package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;

public class GameService {

    Player player;
    Computer computer;
    private int strikeCount;
    private int ballCount;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 2;

    public void setPlayer(String input) {
        player = new Player();
        player.setNumbers(input);
    }

    public void setComputer() {
        computer = new Computer();
        computer.makeThreeDigitNumber();
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
        for(int index = FIRST_INDEX; index <= LAST_INDEX; index++){
            scoreGameWithIndex(index);
        }
    }

    private List<Integer> getPlayerNumbers(){
        return player.getNumbers();
    }

    private List<Integer> getComputersNumbers(){
        return computer.getNumbers();
    }

    private void scoreGameWithIndex(int index){
        if(isStrike(index)) increaseStrike();
        if(isBall(index)) increaseBall();
    }

    private boolean isStrike(int index){
        return getPlayerNumbers().get(index)
                .equals(getComputersNumbers().get(index));
    }

    private boolean isBall(int index){
        return !isStrike(index) && getComputersNumbers().contains(getPlayerNumbers().get(index));
    }

    private void increaseStrike(){
        strikeCount++;
    }

    private void increaseBall(){
        ballCount++;
    }
}
