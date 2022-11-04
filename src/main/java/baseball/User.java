package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {
    List<Integer> computerNumberList;
    boolean keepGame = true;
    boolean gameOngoing = true;

    User() {

    }

    User(List<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }

    void main() {
        while (gameOngoing) {
            int userNumber = inputNumber();
            checkNumber(userNumber);
            List<Integer> userNumberList = numberToList(userNumber);
            int strike = checkStrike(computerNumberList, userNumberList);
            int ball = checkBall(computerNumberList, userNumberList, strike);
            printResult(strike, ball);
            if (strike == 3) {
                gameOngoing = false;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                keepOrNot();
            }
        }
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
        System.out.println("잘못된 값을 입력했습니다.");
        System.out.println("프로그램을 종료합니다.");
        throw new IllegalArgumentException();
    }

    void checkNumber(int userNumber) {
        if (100 <= userNumber & userNumber <= 999) {
            if (numberToList(userNumber).contains(0)) {
                errorControl();
                return;
            }
            return;
        }
        errorControl();
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
                System.out.println("프로그램을 종료합니다.");
                keepGame = false;
                return;
            }
        }
        errorControl();
    }
}
