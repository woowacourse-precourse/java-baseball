package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean finishGame = false;

        while (!finishGame) {

            int answerNumber = getAnswerNumber();

            playGame(answerNumber);

            finishGame = continueOrExit();
        }
    }

    public static int getAnswerNumber() {

        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < Constants.NUMBER_SIZE) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!answerList.contains(randomNumber))
                answerList.add(randomNumber);
        }

        return ListToInteger(answerList);
    }

    public static int ListToInteger(List<Integer> answerList) {

        int answer = 0, digit = 1;

        Collections.reverse(answerList);
        for (Integer number : answerList) {
            answer += number * digit;
            digit *= 10;
        }

        return answer;
    }

    public static void playGame(int answerNumber) {

        boolean equalNumber = false;

        while (!equalNumber) {
            System.out.print("숫자를 입력해주세요 : ");

            int userNumber = getUserNumber();

            int strikes = countStrikes(userNumber, answerNumber);
            int balls = countBalls(userNumber, answerNumber);

            printResult(strikes, balls);

            equalNumber = threeStrikes(strikes);
        }
    }

    public static int getUserNumber() {

        String userString = Console.readLine();

        checkNegativeNumber(userString);
        checkZeroInNumber(userString);
        checkLengthAndDuplication(userString);

        return userStringToInteger(userString);
    }

    public static void checkNegativeNumber(String userString) {
        if (userString.contains("-"))
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);
    }

    public static void checkZeroInNumber(String userString) {
        if (userString.contains("0"))
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);
    }

    public static void checkLengthAndDuplication(String userString) {
        Set<Object> numberSet = new HashSet<>();
        for (int i = 0; i < userString.length(); i++)
            numberSet.add(userString.charAt(i));

        if (userString.length() != Constants.NUMBER_SIZE)
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);

        if (numberSet.size() != Constants.NUMBER_SIZE)
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);
    }

    public static int userStringToInteger(String userString) {

        int userNumber;
        try {
            userNumber = Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);
        }

        return userNumber;
    }

    public static boolean continueOrExit() throws IllegalArgumentException {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int userChoice = userStringToInteger(Console.readLine());

        if (userChoice == Constants.CONTINUE_GAME)
            return false;
        if (userChoice == Constants.EXIT_GAME)
            return true;

        throw new IllegalArgumentException(Constants.INPUT_ERROR_MESSAGE);
    }

    public static int countStrikes(int userNumber, int answerNumber) {

        int strikes = 0;

        for (int i = 0; i < Constants.NUMBER_SIZE; i++) {
            if (userNumber % 10 == answerNumber % 10) strikes += 1;

            userNumber /= 10;
            answerNumber /= 10;
        }

        return strikes;
    }

    public static int countBalls(int userNumber, int answerNumber) {

        int strikes = countStrikes(userNumber, answerNumber);
        int balls = 0;

        List<Integer> userDigits = integerToList(userNumber);
        List<Integer> answerDigits = integerToList(answerNumber);

        for (int i = 0; i < Constants.NUMBER_SIZE; i++) {

            int digit = userDigits.get(i);
            if (answerDigits.contains(digit))
                balls += 1;
        }
        balls -= strikes;

        return balls;
    }

    public static List<Integer> integerToList(Integer number) {

        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < Constants.NUMBER_SIZE; i++) {
            digits.add(number % 10);
            number /= 10;
        }

        return digits;
    }

    public static void printResult(int strikes, int balls) {

        if (strikes + balls == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strikes == 0 && balls != 0) {
            System.out.println(balls + "볼");
            return;
        }

        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
            return;
        }

        System.out.println(balls + "볼 " + strikes + "스트라이크");
    }

    public static boolean threeStrikes(int strikes) {

        return strikes == Constants.NUMBER_SIZE;
    }
}
