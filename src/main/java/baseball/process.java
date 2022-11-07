package baseball;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class process {
    private static final int cnt_nbr= 3;
    private static final int strike_nbr= 2;
    private static final int ball_nbr= 1;
    private static final String str_strike= "스트라이크";
    private static final String str_ball= "볼 ";
    private static final String str_nothing= "낫싱";
    private static final String exit_nbr= "2";
    private static final String three_strike= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String str_exit= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int[] user;
    private int[] computer;

    private int strike = 0;
    private int ball = 0;
    private boolean exit = false;
    public process() {}

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void readyToExit(ArrayNumber computerNumber) {
        String input = inputExit();
        if(exit_nbr.equals(input)) {
            System.out.println("2");
            exit = true;
        } else {
            computerNumber.setRandomNbr();
            System.out.println("1");
            computer = computerNumber.getDigits();
        }
    }

    private String inputExit() {
        System.out.println(str_exit);
        String input = Console.readLine();
        if(!RightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean RightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private int StrikeOrBall(int num, int index) {
        for(int i = 0; i<cnt_nbr; i++) {
            if(computer[i] == num && i == index) {
                return strike_nbr;
            }
            if(computer[i] == num) {
                return ball_nbr;
            }
        }
        return -1;
    }

    private void printResult() {
        System.out.println(getResStr());

        if(strike ==cnt_nbr) {
            System.out.println(three_strike);
        }
    }

    private String getResStr() {
        if(strike == 0 && ball == 0) {
            return str_nothing;
        }
        StringBuilder sb = new StringBuilder();
        if(ball > 0) {
            sb.append(ball).append(str_ball);
        }
        if(strike > 0) {
            sb.append(strike).append(str_strike);
        }
        return sb.toString();
    }
}