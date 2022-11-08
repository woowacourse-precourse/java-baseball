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

    private void calculateScore() {
        for(int i=0;i<CNT;i++) {
            int score = StrikeOrBall(player[i], i);
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

    private int StrikeOrBall(int num, int index) {
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

}
