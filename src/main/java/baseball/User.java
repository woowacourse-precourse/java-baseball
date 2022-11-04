package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {
    List<Integer> computerNumberList;
    static boolean keepGame = true;

    User() {

    }

    User(List<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }

    int inputNumber() {
        int userNumber = -1;

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (checkType(userInput)) {
            userNumber = Integer.parseInt(userInput);
        }
        return userNumber;
    }

    void errorControl() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {

            System.out.println("프로그램을 종료합니다");
        }
    }

    boolean checkNumber(int userNumber) {
        if (100 <= userNumber & userNumber <= 999) {
            if (numberToList(userNumber).contains(0)) {
                errorControl();
                return false;
            }
            return true;
        }
        errorControl();
        return false;
    }

    boolean checkType(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            errorControl();
        }
        return false;
    }

    List<Integer> numberToList(int userNumber) {
        List<Integer> userNumberList = new ArrayList<>(3);
        for (int divideNumber = 100; divideNumber >= 1; divideNumber /= 10) {
            userNumberList.add(userNumber / divideNumber);
            userNumber -= (userNumber / divideNumber) * divideNumber;
        }
        return userNumberList;
    }

    int checkStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(computerNumberList.get(index), userNumberList.get(index))) {
                strike++;
            }
        }
        return strike;
    }

    int checkBall(List<Integer> computerNumberList, List<Integer> userNumberList, int strike) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumberList.contains(userNumberList.get(index))) {
                ball++;
            }
        }
        return ball - strike;
    }

    void printResult(int strike, int ball) {
        if (Objects.equals(strike, 0) & Objects.equals(ball, 0)) {
            System.out.println("낫싱");
            return;
        } else if (Objects.equals(strike, 0)) {
            System.out.println(ball + "볼");
            return;
        } else if (Objects.equals(ball, 0)) {
            System.out.println((strike + "스트라이크"));
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    void keepOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (checkType(userInput)) {
            if (userInput.equals("1")) {
                keepGame = true;
                return;
            } else if (userInput.equals("2")) {
                keepGame = false;
                return;
            }
        }
        errorControl();
    }
}
