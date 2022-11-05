package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean gameLife = true;
        String number;

        while (gameLife) {
            number = setNumber();
            gameLife = playGame(number);
        }
    }

    public static boolean playGame(String number) {

        boolean continueGame = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean nextTurn = true;
        while (nextTurn) {
            String inputNumber = inputNumberFromPlayer();
            checkInputNumberValidation(inputNumber);
            Map<String, Integer> inputNumberResult = analyzeInputNumber(inputNumber, number);
            nextTurn = resultMessagePrint(inputNumberResult);
        }
        String orderNumber = inputOrderNumber();
        checkOrderNumberValidation(orderNumber);
        continueGame = checkOrderNumberValue(orderNumber);

        return continueGame;
    }

    public static boolean checkOrderNumberValue(String orderNumber) {

        if (orderNumber.charAt(0) == '1') {
            return true;
        } else if (orderNumber.charAt(0) == '2') {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void checkOrderNumberValidation(String orderNumber) {

        if (orderNumber.length() == 1 && (orderNumber.charAt(0) == '1' || orderNumber.charAt(0) == '2')) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static String inputOrderNumber() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String orderNumber = Console.readLine();

        return orderNumber;
    }

    public static boolean resultMessagePrint(Map<String, Integer> inputNumberResult) {

        int strikeNumber = inputNumberResult.get("strike");
        int ballNumber = inputNumberResult.get("ball");
        boolean gameResult = true;

        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.println("낫싱");
        } else if (strikeNumber == 3) {
            System.out.println("3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameResult = false;
        } else if (strikeNumber > 0 && ballNumber == 0) {
            System.out.println(strikeNumber + "스트라이크");
        } else if (strikeNumber == 0 && ballNumber > 0) {
            System.out.println(ballNumber + "볼");
        } else if (strikeNumber > 0 && ballNumber > 0) {
            System.out.println(ballNumber + "볼 " + strikeNumber + "스트라이크");
        }

        return gameResult;
    }

    public static Map<String, Integer> analyzeInputNumber(String inputNumber, String number) {

        int strikeNumber = 0;
        int ballNumber = 0;

        for (int pitchingCount = 0; pitchingCount < 3; pitchingCount++) {

            char pitchingValue = inputNumber.charAt(pitchingCount);

            if (checkStrike(pitchingValue, number.charAt(pitchingCount))) {
                strikeNumber++;
            } else if (checkBall(pitchingValue, number)) {
                ballNumber++;
            }
        }
        Map<String, Integer> analyzeResult = Map.of(
                "strike", strikeNumber,
                "ball", ballNumber
        );

        return analyzeResult;
    }

    public static boolean checkBall(char pitchingValue, String numbers) {

        for (int pitchingCount = 0; pitchingCount < 3; pitchingCount++) {
            if (pitchingValue == numbers.charAt(pitchingCount)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkStrike(char pitchingValue, char number) {

        return pitchingValue == number;
    }

    public static void checkInputNumberValidation(String inputNumber) {

        checkLength(inputNumber);

        checkDuplication(inputNumber);

        isNumber(inputNumber);
    }

    public static void isNumber(String inputNumber) {

        for (char number : inputNumber.toCharArray()) {
            if (number > '0' && number <= '9') {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }


    public static void checkDuplication(String inputNumber) {

        char first = inputNumber.charAt(0);
        char second = inputNumber.charAt(1);
        char third = inputNumber.charAt(2);

        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLength(String inputNumber) {

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputNumberFromPlayer() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        return inputNumber;
    }

    public static String setNumber() {

        int first = Randoms.pickNumberInRange(1, 9);
        int second = Randoms.pickNumberInRange(1, 9);
        int third = Randoms.pickNumberInRange(1, 9);

        while (second == first) {
            second = Randoms.pickNumberInRange(1, 9);
        }

        while (third == first || third == second) {
            third = Randoms.pickNumberInRange(1, 9);
        }

        Integer number = (first * 100) + (second * 10) + third;
        return number.toString();
    }
}