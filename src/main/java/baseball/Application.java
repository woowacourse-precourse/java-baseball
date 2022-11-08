package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        startGame();
        baseballProgram();
    }

    static void baseballProgram() {
        List<Integer> computerNumber = generateComputerNumber();
        ballCount result;
        do {
            String userNumber = inputUserNumber();
            result = calculateResult(computerNumber, userNumber);
            printResult(result);
        } while (isWrongAnswer(result));
        clearGame();
        if (continueGame())
            baseballProgram();
    }

    static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    static String inputUserNumber() {
        System.out.printf("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        if (!isValidate(userNumber))
            throwException();
        return userNumber;
    }

    static boolean isValidate(String userNumber) {
        if (userNumber.length() != 3)
            return false;
        Set<Integer> eachNumber = new HashSet<>();
        for (int digit = 0; digit < userNumber.length(); digit++) {
            if (userNumber.charAt(digit) < '1' || userNumber.charAt(digit) > '9')
                return false;
            if (eachNumber.contains(userNumber.charAt(digit) - '0'))
                return false;
            eachNumber.add(userNumber.charAt(digit) - '0');
        }
        return true;
    }

    static void throwException() {
        throw new IllegalArgumentException();
    }

    static ballCount calculateResult(List<Integer> computerNumber, String userNumber) {
        ballCount result = new ballCount(0, 0);

        for (int digit = 0; digit < userNumber.length(); digit++) {
            int eachNumber = userNumber.charAt(digit) - '0';
            if (computerNumber.indexOf(eachNumber) == digit) {
                result.strike++;
                continue;
            }
            if (computerNumber.indexOf(eachNumber) >= 0)
                result.ball++;
        }
        return result;
    }

    static class ballCount {
        int strike, ball;

        ballCount(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }
    }

    static void printResult(ballCount result) {
        if (result.ball > 0)
            System.out.printf(result.ball + "볼 ");
        if (result.strike > 0)
            System.out.printf(result.strike + "스트라이크");
        if (result.strike == 0 && result.ball == 0)
            System.out.printf("낫싱");
        System.out.println();
    }

    static boolean isWrongAnswer(ballCount result) {
        if (result.strike == 3)
            return false;
        return true;
    }

    static void clearGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputMenu = Console.readLine();
        if (inputMenu.equals("1"))
            return true;
        if (inputMenu.equals("2"))
            return false;
        throwException();
        return false;
    }
}