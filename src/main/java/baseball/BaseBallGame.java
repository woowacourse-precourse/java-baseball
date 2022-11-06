package baseball;

import java.util.List;

public class BaseBallGame {
    private static final int STRIKE_CODE= 1;
    private static final int BALL_CODE= 0;
    private static final int GAME_NUMBER_SIZE = 3;

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱";

    private static final String THREE_STRIKE_ANNOUNCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private List<Integer> player;
    private List<Integer> computer;
    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public BaseBallGame() {}

    public void init() {
        Number forPlayer = new Number();
        Number forComputer = new Number();

        forComputer.createRandomNumber();
        computer = forComputer.getGameNumber();

        start(forComputer, forPlayer);
    }

    private void start(Number forComputer, Number forPlayer) {
        while(!exit) {
            forPlayer.getUserNumber();
            player = forPlayer.getGameNumber();
            
            resetScore();
            calculateScore();
            printResult();
            
            if(strike == GAME_NUMBER_SIZE) {
                // 게임 시작 종료 물음
            }
        }
    }

    private void calculateScore() {
        for(int i=0; i<GAME_NUMBER_SIZE; i++) {
            int score = isStrikeOrBall(player.get(i), i);
            if(score == BALL_CODE) {
                ball++;
                continue;
            }
            if(score == STRIKE_CODE) {
                strike++;
            }
        }
    }

    private void printResult() {
        System.out.println(getResultString());
        if(strike == GAME_NUMBER_SIZE) {
            System.out.println(THREE_STRIKE_ANNOUNCE);
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private int isStrikeOrBall(int num, int idx) {
        for(int i=0; i<GAME_NUMBER_SIZE; i++) {
            if(computer.get(i) == num && i == idx) {
                return STRIKE_CODE;
            }
            if(computer.get(i) == num) {
                return BALL_CODE;
            }
        }
        return -1;
    }

    private String getResultString() {
        StringBuilder sb = new StringBuilder();

        if(strike == 0 && ball == 0) {
            return NOTHING;
        }
        
        if(ball > 0) {
            sb.append(ball).append(BALL);
        }
        if(strike > 0) {
            sb.append(strike).append(STRIKE);
        }
        return sb.toString();
    }   
}