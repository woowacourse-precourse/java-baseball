package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {
    private static final int NUMBER_COUNT = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String EXIT_NUMBER = "2";
    private static final String THREE_STRIKE = "3스트라이크";
    private static final String GAME_OVER_NOTICE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_NOTICE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_OR_EXIT_NOTICE = "게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + EXIT_NUMBER + "를 입력하세요.";
    private static final String INPUT_NUMBER_NOTICE = "숫자를 입력해주세요 : ";

    public static void main(String[] args) {
        System.out.println(START_NOTICE);
        while (true) {
            boolean gameResult = playGame();
            if (gameResult == false)
                break;

            System.out.println(RESTART_OR_EXIT_NOTICE);
            String inputRestartOrExit = Console.readLine();
            inputRestartOrExit = checkInputRestartOrExitIsValid(inputRestartOrExit);
            if (inputRestartOrExit.equals("2")) {
                break;
            }
        }
    }

    public static boolean playGame() {
        List<Integer> computerNumber = createThreeDigitsRandomNumber();
        while (true) {
            System.out.print(INPUT_NUMBER_NOTICE);
            String inputNumber = Console.readLine();
            if (!checkNumberIsValid(inputNumber)) {
                return false;
            }
            List<Integer> userNumber = changeStringToList(inputNumber);
            String result = countBallStrike(computerNumber, userNumber);
            System.out.println(result);
            if (result.equals(THREE_STRIKE)) {
                System.out.println(GAME_OVER_NOTICE);
                return true;
            }
        }
    }

    public static List<Integer> createThreeDigitsRandomNumber() {
        List<Integer> computerList = new ArrayList<>();
        while (computerList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }
        return computerList;
    }

    public static String countBallStrike(List<Integer> computerList, List<Integer> userList) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < computerList.size(); i++) {
            int computerNumber = computerList.get(i);
            int userNumber = userList.get(i);

            if (computerNumber == userNumber) {
                strikeCount++;
            } else if (computerList.contains(userNumber)) {
                ballCount++;
            }
        }

        return toStringBallStrike(ballCount, strikeCount);
    }

    public static String toStringBallStrike(int ballCount, int strikeCount) {
        if (ballCount + strikeCount == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (ballCount != 0) {
            result.append(Integer.toString(ballCount) + "볼 ");
        }
        if (strikeCount != 0) {
            result.append(Integer.toString(strikeCount) + "스트라이크");
        }
        return result.toString().trim();
    }

    public static boolean checkNumberIsValid(String number) throws IllegalArgumentException {
        boolean result = checkNumberLengthIsThree(number) && checkNumberIsDuplicated(number);
        if (result == false) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public static boolean checkNumberLengthIsThree(String number) {
        String changedNumber = number.replaceAll("[^1-9]", "");
        return changedNumber.length() == NUMBER_COUNT;
    }

    public static boolean checkNumberIsDuplicated(String number) {
        String[] numberSplit = number.split("");
        HashSet<String> set = new HashSet<>(Arrays.asList(numberSplit));
        return set.size() == NUMBER_COUNT;
    }

    public static List<Integer> changeStringToList(String number) {
        List<Integer> numberList = new ArrayList<>();
        char[] numberToCharArr = number.toCharArray();
        for (int i = 0; i < numberToCharArr.length; i++) {
            numberList.add(numberToCharArr[i] - '0');
        }
        return numberList;
    }

    public static String checkInputRestartOrExitIsValid(String number) throws IllegalArgumentException {
        if (!number.equals(RESTART_NUMBER) && !number.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

}
