package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;

import java.util.List;

public class Game {
    private static final int NOT_FOUND=-1;
    private static final int ANSWER=3;
    private static final int NO_COUNT=0;
    private static final int COUNT=1;
    private static final String NOTHING_MESSAGE="낫싱";
    private static final String BALL_MESSAGE="%d볼\n";
    private static final String STRIKE_MESSAGE="%d스트라이크\n";
    private static final String BALL_AND_STRIKE="%d볼 %d스트라이크\n";
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
    public void judgeState(Computer computer, Player player){
        int playerNumber;
        int computerNumber;
        List<Integer> opponentNumbers=computer.getDigits();
        for(int opponentNumber: opponentNumbers){
            playerNumber=player.getNumberPosition(opponentNumber);
            computerNumber=computer.getNumberPosition(opponentNumber);
            countStrike(playerNumber, computerNumber);
            countBall(playerNumber, computerNumber);
        }
    }
    public boolean isFinished(){
        return strikeCount!=ANSWER;
    }
    public void initializeStrikeAndBallCount(){
        strikeCount=NO_COUNT;
        ballCount=NO_COUNT;
    }
    public void showResult(){
        if(strikeCount==NO_COUNT&&ballCount==NO_COUNT){
            System.out.println(NOTHING_MESSAGE);
        }
        else if (ballCount==NO_COUNT) {
            System.out.printf(STRIKE_MESSAGE, strikeCount);
        }
        else if (strikeCount==NO_COUNT) {
            System.out.printf(BALL_MESSAGE, ballCount);
        }
        else{
            System.out.printf(BALL_AND_STRIKE, ballCount, strikeCount);
        }
    }
}
