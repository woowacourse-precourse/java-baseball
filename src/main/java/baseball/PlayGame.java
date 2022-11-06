package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class PlayGame {

    public static void run(String answer) {
        String inputString = "";
        List<Integer> inputResult;

        while (!inputString.equals(answer)) {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = Console.readLine();

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

    public static int isStop() {
        int res;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String stopFlag = Console.readLine();

        if (stopFlag.equals("1")) {
            res = 0;
        }
        else if (stopFlag.equals("2")){
            res = 1;
        }
        else {
            throw new IllegalArgumentException();
        }

        return res;
    }

    public static void checkInputString(String inputString) {

        if (checkInputLength(inputString) || checkInputRepetition(inputString) || checkInputInteger(inputString)) {
            throw new IllegalArgumentException();
        }

    }

    public static boolean checkInputLength(String inputString) {
        boolean res;

        if (inputString.length() != 3) {
            res = true;
        }
        else {
            res = false;
        }

        return res;
    }

    public static boolean checkInputRepetition(String inputString) {
        boolean res = false;

        for (int idx = 0; idx < 3; idx++) {
            if (countElement(inputString, inputString.charAt(idx)) != 1) {
                res = true;
                break;
            }
        }

        return res;
    }

    public static int countElement(String inputString, char inputChar) {
        int res = 0;

        for (int idx = 0; idx < inputString.length(); idx++) {
            if (inputString.charAt(idx) == inputChar) {
                res += 1;
            }
        }

        return res;
    }

    public static boolean checkInputInteger(String inputString) {
        boolean res = false;

        for (int idx = 0; idx < 3; idx++) {
            int inputChar = inputString.charAt(idx) - '0';

            if (inputChar < 1 || inputChar > 9) {
                res = true;
                break;
            }
        }

        return res;
    }
}
