package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static class BaseBall {

        private static final int NUM_DIGIT = 3;
        private static final int NUM_BOUNDARY = 10;
        private static final boolean PLAYING = true;

        private int[] goalArr;
        private int[] usageArr;

        public BaseBall() {
            goalArr = new int[NUM_DIGIT];
            usageArr = new int[NUM_BOUNDARY];
        }

        public void game() {
            gameInit();
            gamePrepare();
            gamePlayLoop();
        }

        private void gamePlayLoop() {
            while (PLAYING) {
                if (gamePlay()) {
                    break;
                }
            }
        }

        private boolean gamePlay() {
            String ball = Ready();
//            play();
//            return nextAction();
            return false;
        }

        private String Ready() {
//            printSetBallStatus();
//            String ball = setBall();
//            return trimBall(ball);
            return "";
        }

        private void gameInit() {
            printOpeningStatus();
        }

        private void printOpeningStatus() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        private void gamePrepare() {
            makeGoal();
        }

        private void makeGoal() {
            for (int idx = 0; idx < NUM_DIGIT; idx++) {
                int randomNum = makeNumber();
                makeNumberOrder(randomNum, idx);
                makeNumberUsage(randomNum);
            }
        }

        private void makeNumberUsage(int randomNum) {
            this.usageArr[randomNum] += 1;
        }

        private void makeNumberOrder(int randomNum, int idx) {
            this.goalArr[idx] = randomNum;
        }

        private int makeNumber() {
            return Randoms.pickNumberInRange(1, 9);
        }

    }

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        baseBall.game();
    }
}
