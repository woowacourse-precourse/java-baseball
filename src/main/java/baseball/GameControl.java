package baseball;

import java.util.*;

public class GameControl {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int NUMBER_SIZE = 3;
    private static final String Ball_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final boolean PLAYING = true;
    private static final boolean GAMEOVER = false;

    private List<Integer> computer;
    private List<Integer> player;

    private int strike = 0;
    private int ball = 0;
    private int strikePlusBall = 0;
    private boolean isGameOver = PLAYING;

    public GameControl() {}

    public void startGame() {
        startMessage();
        Computer computerNumber = new Computer();
        Player playerNumber = new Player();

        computerNumber.setNumbers();
        computer = computerNumber.getNumbers();

        while(isGameOver) {
            playerNumber.setNumbers();
            player = playerNumber.getNumbers();
            scoreCalculation(player);
        }
    }

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void scoreCalculation(List<Integer> player) {
        for(int i=0; i<NUMBER_SIZE; i++){
            if(player.get(i) == computer.get(i)){
                strike++;
            }
            if(computer.contains(player.get(i))){
                strikePlusBall++;
            }
        ball = strikePlusBall - strike;
        }
    }

    public void printScoreMessage() {
        if(ball != 0){
            System.out.print(ball + Ball_MESSAGE + " ");
        }
        if(strike != 0){
            System.out.println(strike + STRIKE_MESSAGE);
        }
        if(ball == 0 && strike == 0){
            System.out.println(NOTHING);
        }
    }

    public void resetScore() {
        strike = 0;
        ball = 0;
        strikePlusBall = 0;
    }
}
