package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class GameSystem {

    static final int MAX_COUNT = 3;
    static final int STRIKE_CASE = 2;
    static final int BALL_CASE = 1;

    private int strike = 0;
    private int ball = 0;
    private boolean keepGoing = false;

    private int[] computerNumber;
    private int[] userNumber;

    public GameSystem() {}

    public void startGame() {

        Number answerNumber = new Number();
        Number userPrediction = new Number();

        initializeRandomNumber(answerNumber);

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!keepGoing) {

            inputUserNumber(userPrediction);

            initializeScore();
            calcScore();
            printResult();

            if(strike == MAX_COUNT) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                checkKeepGoing(answerNumber);
            }
        }
    }

    private void initializeRandomNumber(Number answerNumber) {
        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();
    }

    private void inputUserNumber(Number userPrediction) {
        userPrediction.inputPrediction();
        userNumber = userPrediction.getDigits();
    }

    private void initializeScore() {
        strike = 0;
        ball = 0;
    }

    private void calcScore() {
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

    private int checkBallOrStrike(int caseNumber, int caseIndex) {
        for(int answerCaseIndex = 0; answerCaseIndex < MAX_COUNT; answerCaseIndex++) {
            int answerCaseNumber = computerNumber[answerCaseIndex];

            if(caseNumber == answerCaseNumber && caseIndex == answerCaseIndex) {
                return STRIKE_CASE;
            }
            if(caseNumber == answerCaseNumber) {
                return BALL_CASE;
            }
        }
        return 0;
    }

    private void printResult() {
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

    private void checkKeepGoing(Number answerNumber) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputExit();
        if(input.equals("1")) {
            initializeRandomNumber(answerNumber);
        }
        if(input.equals("2")) {
            keepGoing = true;
        }
    }

    private String inputExit() {
        String input = Console.readLine();
        if(!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }



}