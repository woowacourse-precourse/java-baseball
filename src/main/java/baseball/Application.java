package baseball;



public class Application {

    static int MAX_COUNT = 3;
    static int STRIKE_CASE = 2;
    static int BALL_CASE = 1;


    static int strike = 0;
    static int ball = 0;

    static int[] computerNumber;
    static int[] userNumber;

    public static void main(String[] args) {

        boolean keepGoing = true;

        Number answerNumber = new Number();
        Number userPrediction = new Number();

        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();


        while(keepGoing) {
            userPrediction.inputPrediction();
            userNumber = userPrediction.getDigits();

            initializeScore();
            calcScore();
            printResult();

        }

    }

    private static void printResult() {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        StringBuilder sb = new StringBuilder();
        if(ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if(strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb);
    }

    private static void calcScore() {
        for(int i = 0; i < MAX_COUNT; i++) {
            int checkCase = checkBallOrStike(userNumber[i], i);
            if(checkCase == BALL_CASE) {
                ball++;
                continue;
            }
            if(checkCase == STRIKE_CASE) {
                strike++;
            }
        }
    }

    private static int checkBallOrStike(int num, int index) {
        for(int j = 0; j < MAX_COUNT; j++) {
            if(num == computerNumber[j] && j == index) {
                return STRIKE_CASE;
            }
            if(num == computerNumber[j]) {
                return BALL_CASE;
            }
        }
        return 0;
    }

    private static void initializeScore() {
        strike = 0;
        ball = 0;
    }

}