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
            List<Integer> randomNumber = getRandomNumber();
            
            printEndMessage();
        }


    }

    public static List<Integer> getRandomNumber() {
        List<Integer> baseballNumber = new ArrayList<>();
        while (baseballNumber.size() <= 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }
        return baseballNumber;
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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


}
