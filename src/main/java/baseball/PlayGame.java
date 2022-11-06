package baseball;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

    static Scanner scan = new Scanner(System.in);

    public static void run(String answer) {
        String inputString = "";
        List<Integer> inputResult = new ArrayList<>();

        while (!inputString.equals(answer)) {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = scan.nextLine();

            checkInputString(inputString);

            inputResult = compareString(inputString, answer);

            printResult(inputResult);
        }
    }

    public static List<Integer> compareString(String input, String answer) {
        List<Integer> res = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        for (int idx = 0; idx < 3; idx++) {
            char inputChar = input.charAt(idx);

            if (answer.indexOf(inputChar) == idx) {
                strike += 1;
            }
            else if (answer.indexOf(inputChar) != -1) {
                ball += 1;
            }
        }

        res.add(ball);
        res.add(strike);

        return res;
    }

    public static void printResult(List<Integer> inputResult) {
        int ball = inputResult.get(0);
        int strike = inputResult.get(1);
        String res = "";

        if (ball > 0 && strike > 0) {
            res = Integer.toString(ball).concat("볼 ").concat(Integer.toString(strike)).concat("스트라이크");
        }
        else if (ball > 0) {
            res = Integer.toString(ball).concat("볼");
        }
        else if (strike > 0) {
            res = Integer.toString(strike).concat("스트라이크");
        }
        else {
            res = "낫싱";
        }

        System.out.println(res);
    }

    public static boolean isStop() {
        boolean res = false;

        String stopFlag = "";

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        stopFlag = scan.nextLine();

        if (stopFlag.equals("1")) {
            res = false;
        }
        else if (stopFlag.equals("2")){
            res = true;
        }
        else {
            System.out.println("잘못된 입력입니다.");
            throw new IllegalArgumentException();
        }

        return res;
    }

    public static void checkInputString(String inputString) {
        boolean errorFlag = false;

        if (inputString.length() != 3) {
            errorFlag = true;
        }

        for (int idx = 0; idx < 3; idx++) {
            int inputChar = inputString.charAt(idx) - '0';

            if (inputChar < 1 || inputChar > 9) {
                errorFlag = true;
            }
        }

        if (errorFlag) {
            System.out.println("잘못된 입력입니다.");
            throw new IllegalArgumentException();
        }
    }
}
