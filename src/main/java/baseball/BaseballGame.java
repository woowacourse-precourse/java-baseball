package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class BaseballGame {
    private static final int CNT = 3;
    private static final int STRIKE_NUM= 2;
    private static final int BALL_NUM= 1;
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String EXIT_CODE = "2";

    private int[] player;
    private int[] computer;
    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public BaseballGame() {}

    public void startGame() {
        Number playerNum = new Number();
        Number computerNum = new Number();

        computerNum.setRandomNumber();
        computer = computerNum.getDigits();

        while(!exit) {
            playerNum.inputAnswer();
            player = playerNum.getDigits();

            resetScore();
            calculateScore();
            printResult();

            if(strike == CNT) {
                readyToExit(computerNum);
            }
        }
    }

    private void calculateScore() {
        for(int i=0;i<CNT;i++) {
            int score = isStrikeOrBall(player[i], i);
            if(score == BALL_NUM) {
                ball++;
                continue;
            }
            if(score == STRIKE_NUM) {
                strike++;
            }
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void readyToExit(Number computerNumber) {
        String input = inputExit();
        if(EXIT_CODE.equals(input)) {
            exit = true;
        } else {
            computerNumber.setRandomNumber();
            computer = computerNumber.getDigits();
        }
    }

    private String inputExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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

    private int isStrikeOrBall(int num, int index) {
        for(int i=0;i<CNT;i++) {
            if(computer[i] == num && i == index) {
                return STRIKE_NUM;
            }
            if(computer[i] == num) {
                return BALL_NUM;
            }
        }
        return -1;
    }

    private void printResult() {
        System.out.println(getResultString());
        if(strike == CNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private String getResultString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if(ball > 0) {
            sb.append(ball).append(BALL_STR);
        }
        if(strike > 0) {
            sb.append(strike).append(STRIKE_STR);
        }
        return sb.toString();
    }
}
