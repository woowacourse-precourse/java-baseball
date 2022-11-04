package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        printStartMessage();
        boolean gameFlag = true;
        while (gameFlag) {
            String randomNumber = getRandomNumber();
            startGame(randomNumber);
            gameFlag = getRestartFlag();
        }
    }

    public static String getRandomNumber() {
        StringBuilder baseballNumber = new StringBuilder();
        while (baseballNumber.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String number = Integer.toString(randomNumber);

            if (!baseballNumber.toString().contains(number)) {
                baseballNumber.append(number);
            }
        }
        return baseballNumber.toString();
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameResult(int ballCount, int strikeCount) {
        StringBuilder resultMessage = new StringBuilder();
        if (ballCount != 0) {
            resultMessage.append(ballCount + "볼");
        }

        if (strikeCount != 0) {
            if (resultMessage.length() != 0) {
                resultMessage.append(" ");
            }
            resultMessage.append(strikeCount + "스트라이크");
        }

        if (resultMessage.length() == 0) {
            resultMessage.append("낫싱");
        }
        System.out.println(resultMessage.toString());
    }

    public static boolean isWrongInputNumber(String userInputNumber) {
        int inputNumber = Integer.parseInt(userInputNumber);

        // 세 자리 확인
        if (inputNumber < 100 || inputNumber > 999) {
            return true;
        }

        // 중복 숫자 확인
        String[] splitNumber = userInputNumber.split("");
        for (String number : splitNumber) {
            if (Collections.frequency(Arrays.asList(splitNumber), number) != 1) {
                return true;
            }
        }

        return false;
    }

    public static String getUserInputNumber() {
        String userInputNumber = Console.readLine();
        try {
            if (isWrongInputNumber(userInputNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return userInputNumber;
    }

    public static int getStrikeCount(String userInputNumber, String randomNumber) {
        int strikeCount = 0;
        for (int numberIndex = 0; numberIndex < 3; numberIndex++) {
            if (userInputNumber.charAt(numberIndex) == randomNumber.charAt(numberIndex)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(String userInputNumber, String randomNumber) {
        int ballCount = 0;
        int strikeCount = getStrikeCount(userInputNumber, randomNumber);
        for (String number : userInputNumber.split("")) {
            if (randomNumber.contains(number)) {
                ballCount++;
            }
        }

        return ballCount - strikeCount;
    }

    public static boolean isThreeStrike(int strikeCount) {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public static void startGame(String randomNumber) {
        while (true) {
            printInputMessage();
            String userInputNumber = getUserInputNumber();

            int strikeCount = getStrikeCount(userInputNumber, randomNumber);
            int ballCount = getBallCount(userInputNumber, randomNumber);
            printGameResult(ballCount, strikeCount);

            if (isThreeStrike(strikeCount)) {
                printEndMessage();
                break;
            }
        }
    }

    public static boolean getRestartFlag() {
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
