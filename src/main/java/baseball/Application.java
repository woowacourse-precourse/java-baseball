package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static class BaseBall {

        private static final int NUM_DIGIT = 3;
        private static final int NUM_BOUNDARY = 10;
        private static final boolean PLAYING = true;
        private static final boolean NOT_VERIFY = false;
        private static final boolean VERIFY = true;
        private static final boolean GAME_END = true;
        private static final boolean GAME_CONTINUE = false;
        private static final boolean GAME_START = false;
        private static final boolean GAME_EXIT = true;

        private int[] goalArr;
        private int[] goalUsageArr;
        private int[] ballArr;

        private boolean[] isStrike;
        private int numBall;
        private int numStrike;

        private StringBuilder sb;

        public BaseBall() {
            goalArr = new int[NUM_DIGIT];
            goalUsageArr = new int[NUM_BOUNDARY];
            ballArr = new int[NUM_DIGIT];
        }

        public void game() {
            gameInit();
            gameRunLoop();
        }

        private void gameRunLoop() {
            while (PLAYING) {
                if (gameRun()) {
                    break;
                }
            }
        }

        private boolean gameRun() {
            gamePrepare();
            gamePlay();
            return newGameCheck();
        }

        private boolean newGameCheck() {
            String order = confirmNextAction();

            if (verifyOrder(order)) {

            } else {
                throw new IllegalArgumentException();
            }

            if (order.equals(1)) {
                return GAME_START;
            } else if(order.equals(2)){
                return GAME_EXIT;
            }
        }

        private String confirmNextAction() {
            printNewGameStatus();
            return readLine();
        }

        private void printNewGameStatus() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
            play();
            return nextAction();
        }

        private boolean nextAction() {
            if (isCompleteGoal()) {
                printCelebrateStatus();
                return GAME_END;
            } else {
                return GAME_CONTINUE;
            }
        }

        private void printCelebrateStatus() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        private boolean isCompleteGoal() {
            if (numStrike == NUM_DIGIT) {
                return GAME_END;
            } else {
                return GAME_CONTINUE;
            }
        }

        private void play() {
            checkStrike();
            checkBall();
            printPlayStatus();
        }

        private void printPlayStatus() {
            sb = new StringBuilder();
            if (numBall > 0) {
                sb.append(numBall).append("볼");
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (numStrike > 0) {
                sb.append(numStrike).append("스트라이크");
            }
            if (sb.length() == 0) {
                sb.append("낫싱");
            }

            System.out.println(sb.toString());
        }

        private void checkBall() {
            numBall = 0;

            for (int idx = 0; idx < NUM_DIGIT; idx++) {
                if (isStrike[idx]) {
                    continue;
                }

                if (goalUsageArr[ballArr[idx]] != 0) {
                    numBall += 1;
                }
            }
        }

        private void checkStrike() {
            isStrike = new boolean[NUM_DIGIT];
            numStrike = 0;

            for (int idx = 0; idx < NUM_DIGIT; idx++) {
                if (goalArr[idx] == ballArr[idx]) {
                    isStrike[idx] = true;
                    numStrike += 1;
                }
            }
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
                pow += 1;
            }
        }

        private int digitNumber(int number, int pow) {
            return number % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
        }

        private boolean verifyBall(String ball) {
            if (!verifyLength(ball) || !verifyIsNumber(ball) || !verifyDupNumber(ball)) {
                return NOT_VERIFY;
            } else {
                return VERIFY;
            }
        }

        private boolean verifyDupNumber(String ball) {
            int ballNumber = Integer.parseInt(ball);
            int[] verifyDup = new int[NUM_BOUNDARY];

            int pow = 0;
            while (ballNumber >= Math.pow(10, pow)) {
                int digit = digitNumber(ballNumber, pow);

                if (verifyDup[digit] != 0) {
                    return NOT_VERIFY;
                }

                verifyDup[digit] += 1;
                pow += 1;
            }

            return VERIFY;
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
            return readLine();
        }

        private String readLine() {
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
            int number = Randoms.pickNumberInRange(1, 9);
            while (this.goalUsageArr[number] != 0) {
                number = Randoms.pickNumberInRange(1, 9);
            }
            return number;
        }

    }

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        baseBall.game();
    }
}
