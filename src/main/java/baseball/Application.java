package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static class BaseBall {

        private static final int NUM_DIGIT = 3;
        private static final int NUM_BOUNDARY = 10;
        private static final boolean PLAYING = true;
        private static final boolean NOT_VERIFY = false;
        private static final boolean VERIFY = true;

        private int[] goalArr;
        private int[] goalUsageArr;
        private int[] ballArr;
        private int[] ballUsageArr;

        public BaseBall() {
            goalArr = new int[NUM_DIGIT];
            goalUsageArr = new int[NUM_BOUNDARY];
            ballArr = new int[NUM_DIGIT];
            ballUsageArr = new int[NUM_BOUNDARY];
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
            Ready();
//            play();
//            return nextAction();
            return false;
        }

        private void Ready() {
            String ball = inputBall();
            if (verifyBall(ball)) {
                makeBall(ball);
            } else {
                throw new IllegalArgumentException();
            }
        }

        private void makeBall(String ball) {
            int ballNumber = Integer.parseInt(ball);

            int pow = 0;
            while (ballNumber >= Math.pow(10, pow)) {
                int digit = digitNumber(ballNumber, pow);

                makeNumberOrder(this.ballArr, digit, pow);
                makeNumberUsage(this.ballUsageArr, digit);

                pow += 1;
            }
        }

        private int digitNumber(int number, int pow) {
            return number % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
        }

        private boolean verifyBall(String ball) {
            if (!verifyLength(ball) || !verifyIsNumber(ball)) {
                return NOT_VERIFY;
            } else {
                return VERIFY;
            }
        }

        private boolean verifyIsNumber(String ball) {
            try {
                int number = Integer.parseInt(ball);
                return VERIFY;
            } catch (NumberFormatException e) {
                return NOT_VERIFY;
            }
        }

        private boolean verifyLength(String ball) {
            if (ball.length() > NUM_DIGIT) {
                return NOT_VERIFY;
            } else {
                return VERIFY;
            }
        }

        private String inputBall() {
            printSetBallStatus();
            return setBall();
        }

        private String setBall() {
            return camp.nextstep.edu.missionutils.Console.readLine();
        }

        private void printSetBallStatus() {
            System.out.print("숫자를 입력해주세요 : ");
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
                makeNumberOrder(this.goalArr, randomNum, idx);
                makeNumberUsage(this.goalUsageArr, randomNum);
            }
        }

        private void makeNumberUsage(int[] arr, int num) {
            arr[num] += 1;
        }

        private void makeNumberOrder(int[] arr, int num, int idx) {
            arr[idx] = num;
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
