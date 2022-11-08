package baseball.entity;

import baseball.constant.Message;

public class Game {

    // 스트라이크 개수, 볼 개수를 관리하는 객체 Score
    // 게임 진행 상태
    private static final int RUNNING = 0;
    private static final int START = 1;
    private static final int STOP = 2;

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Score score = new Score();

    private int GAME_STATE = START;

    public void init() {
        computer.createRandomNumber();
    }

    public void start() {
        while (GAME_STATE != STOP) {
            run();
        }
        checkRestart();
    }

    private void run() {
        GAME_STATE = RUNNING;
        System.out.println(Message.INPUT_MESSAGE);
        input();
        updateScore();
        printResult();
    }


    // input(): 유저에게 입력 받기
    private void input() {
        player.enterInput();
    }

    // updateScore(): 볼 개수와 스트라이크 개수
    private void updateScore() {
        computer.countBallAndStrike(player.getPlayerNumbers(), score);
    }

    private void printResult() {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println(Message.NOTHING);
            return;
        }
        if (score.getStrike() == 3) {
            System.out.println(score.getStrike() + Message.STRIKE);
            System.out.println(Message.END_MESSAGE);
            GAME_STATE = STOP;
            return;
        }
        String resultMessage = score.getBall() + Message.BALL + " " + score.getStrike() + Message.STRIKE;
        System.out.println(resultMessage);
    }

    public boolean stopGame() {
        if (GAME_STATE == STOP) {
            return true;
        }
        return false;
    }

    public void checkRestart() {
        System.out.println(Message.RESTART_MESSAGE);
        GAME_STATE = player.enterAnswer();
    }

}