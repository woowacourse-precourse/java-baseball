package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    static final int MAX_COUNT = 3;
    static final int STRIKE_CASE = 2;
    static final int BALL_CASE = 1;

    static int strike = 0;
    static int ball = 0;
    static boolean keepGoing = true;

    static int[] computerNumber;
    static int[] userNumber;

    public static void main(String[] args) {


        Number answerNumber = new Number();
        Number userPrediction = new Number();

        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(keepGoing) {

            userPrediction.inputPrediction();
            userNumber = userPrediction.getDigits();

            initializeScore();
            calcScore();
            printResult();

            if(strike == MAX_COUNT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                checkKeepGoing(answerNumber);
            }
        }

    }

    private static void initializeScore() {
        strike = 0;
        ball = 0;
    }

    private static void calcScore() {
        for(int i = 0; i < MAX_COUNT; i++) {
            int checkCase = checkBallOrStrike(userNumber[i], i);
            if(checkCase == BALL_CASE) {
                ball++;
                continue;
            }
            if(checkCase == STRIKE_CASE) {
                strike++;
            }
        }
    }

    private static int checkBallOrStrike(int caseNumber, int caseIndex) {
        for(int answerCaseIndex = 0; answerCaseIndex < MAX_COUNT; answerCaseIndex++) {
            int answerCaseNumber = computerNumber[answerCaseIndex];

            if(caseNumber == answerCaseNumber && answerCaseIndex == caseIndex) {
                return STRIKE_CASE;
            }
            if(caseNumber == answerCaseNumber) {
                return BALL_CASE;
            }
        }
        return 0;
    }

    private static void printResult() {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        StringBuilder ballAndStrikeSentence = new StringBuilder();
        if(ball > 0) {
            ballAndStrikeSentence.append(ball).append("볼 ");
        }
        if(strike > 0) {
            ballAndStrikeSentence.append(strike).append("스트라이크");
        }
        System.out.println(ballAndStrikeSentence);
    }

    private static void checkKeepGoing(Number answerNumber) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(input.equals("1")) {
            answerNumber.setRandomNumber();
            computerNumber = answerNumber.getDigits();
        }
        if(input.equals("2")) {
            keepGoing = false;
        }
    }

}