package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class GameControl {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STOP_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String Ball_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String RESTART_CODE = "1";
    private static final String GAME_OVER_CODE = "2";
    private static final boolean PLAYING = true;
    private static final boolean GAMEOVER = false;
    private static final int NUMBER_COUNT = 3;

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
            printScore();
            isThreeStrike(computerNumber);
            resetScore();
        }
    }

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void scoreCalculation(List<Integer> player) {
        for(int i = 0; i< NUMBER_COUNT; i++) {
            if(player.get(i) == computer.get(i)) {
                strike++;
            }
            if(computer.contains(player.get(i))) {
                strikePlusBall++;
            }
            ball = strikePlusBall - strike;
        }
    }

    public void printScore() {
        if(ball != 0) {
            System.out.print(ball + Ball_MESSAGE + " ");
        }
        if(strike != 0) {
            System.out.print(strike + STRIKE_MESSAGE);
        }
        if(ball == 0 && strike == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    public void resetScore() {
        strike = 0;
        ball = 0;
        strikePlusBall = 0;
    }

    public void gameStop() {
        System.out.println(STOP_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

    public void isRestart(Computer computerNumber) {
        String restartCode = Console.readLine();
        if(!isRestartCode(restartCode)){
            throw new IllegalArgumentException();
        }
        if(restartCode.equals(GAME_OVER_CODE)) {
            isGameOver = GAMEOVER;
        } else {
            computerNumber.setNumbers();
            computer = computerNumber.getNumbers();
        }
    }

    public void isThreeStrike(Computer computerNumber) {
        if(strike == NUMBER_COUNT) {
            gameStop();
            isRestart(computerNumber);
        }
    }

    public boolean isRestartCode(String restartCode) {
        if(!restartCode.equals(RESTART_CODE) && !restartCode.equals(GAME_OVER_CODE)){
            return false;
        } else {
            return true;
        }
    }
}
