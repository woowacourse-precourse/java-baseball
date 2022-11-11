package baseball;

import camp.nextstep.edu.missionutils.Console;


public class ResultGenerator {


    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final String FINAL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private int strike = 0;
    private int ball = 0;

    private String getResultString() {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        StringBuilder stringMaker = new StringBuilder();
        if (ball > 0) {
            stringMaker.append(ball).append(BALL_STR);
        }
        if (strike > 0) {
            stringMaker.append(strike).append(STRIKE_STR);
        }
        return stringMaker.toString();
    }


    public void printResult() {
        System.out.println(getResultString());
        if (strike == 3) {
            System.out.println(FINAL);
        }
    }


    public void inputExit() {
        ExcepetionCase exception = new ExcepetionCase();
        System.out.println(AGAIN);
        String input = Console.readLine();
        if (!exception.oneOrTwo(input)) {
            throw new IllegalArgumentException();
        }
        if ("2".equals(input)) {
            boolean exit = true;
        }
    }


    public String getResultString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        StringBuilder stringMaker = new StringBuilder();
        if (ball > 0) {
            stringMaker.append(ball).append(BALL_STR);
        }
        if (strike > 0) {
            stringMaker.append(strike).append(STRIKE_STR);
        }
        return stringMaker.toString();
    }


    public String printResult(int strike, int ball) {
        if (strike == 3) {

            return getResultString(strike, ball) + "\n" + FINAL;

        }
        return getResultString(strike, ball);
    }


    public boolean inputExit(String input) {
        ExcepetionCase exception = new ExcepetionCase();

        boolean exit = false;

        if (!exception.oneOrTwo(input)) {
            throw new IllegalArgumentException();
        }


        if ("2".equals(input)) {
            exit = true;
        } else if ("1".equals(input)){
            exit = false;
        }

        return exit;
    }


}
