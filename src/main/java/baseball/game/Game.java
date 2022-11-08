package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;

import java.util.List;

public class Game {
    private static final int NOT_FOUND=-1;
    private static final int ANSWER=3;
    private static final int NO_COUNT=0;
    private static final int COUNT=1;
    private static int strikeCount=0;
    private static int ballCount=0;
    public Computer prepareComputer(Computer computer){
        computer.createRandomNumbers();
        return computer;
    }
    public Player preparePlayer(Player player){
        player.createNumbers();
        return player;
    }
    private void countStrike(int playerNumber, int opponentNumber){

        if(playerNumber==opponentNumber){
            strikeCount+=COUNT;
        }
    }
    private void countBall(int playerNumber, int opponentNumber){
        if(playerNumber!=opponentNumber && playerNumber!=NOT_FOUND){
            ballCount+=COUNT;
        }
    }
    public boolean isFinished(){
        return strikeCount!=ANSWER;
    }
}
