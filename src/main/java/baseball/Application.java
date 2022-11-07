package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int[] getNumbersToUserNumber(String userNumber) {
        try {
            return Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static int getNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidUserNumber(String userNumber) {
        if (userNumber.length() != 3 || userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (isDistinct(userNumber)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isValidCommandNumber(String commandNumber) {
        if (commandNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (!(commandNumber.contains("1") || commandNumber.contains("2"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isDistinct(String number) {
        return number.length() != Stream.of(number.split("")).distinct().count();
    }

    static List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    static int[] getGameResult(List<Integer> computerNumbers, int[] userNumbers) {
        int[] gameResult = {0, 0};   //스트라이크, 볼

        for (int index = 0; index < 3; index++) {
            if (computerNumbers.get(index).equals(userNumbers[index])) {
                gameResult[0] += 1;

            } else if (computerNumbers.contains(userNumbers[index])) {
                gameResult[1] += 1;
            }
        }
        return gameResult;
    }
}
