package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private String s;

    public void printLine(String s) {
        try {
            System.out.println(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void print(String s) {
        try {
            System.out.print(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public String inputNumber() {
        String s;
        try {
            // 형변환 check
            s = Console.readLine();
            if(s.length() > 3 || !s.matches("^[1-9]+$")){
                throw new IllegalArgumentException();
            }
            return s;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void printResult(int ball, int strike) {
        try {
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
