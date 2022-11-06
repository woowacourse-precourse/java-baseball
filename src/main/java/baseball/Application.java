package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int opponentNum = generateOpponentNumber();
        int playerNum = readPlayerNum();

        List<Integer> result = getResult(opponentNum, playerNum);

        return;
    }

    public static List<Integer> getResult(int opponentNum, int playerNum) {
        List<Integer> opponentList = threeDigitsToNumList(opponentNum);
        List<Integer> playerList = threeDigitsToNumList(playerNum);

        int ballCount = 0;
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (playerList.get(index).equals(opponentList.get(index))) {
                strikeCount++;
                continue;
            }
            if (opponentList.contains(playerList.get(index))) {
                ballCount++;
            }
        }

        List<Integer> result = new ArrayList<>(2);
        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }

    private static int readPlayerNum() {
        int inputNum;
        try {
            inputNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        validatePlayerNum(inputNum);

        return inputNum;
    }

    public static void validatePlayerNum(int number) {
        validateNumLength(number);
        validateOneToNine(number);
        validateNotDuplicate(number);
    }

    private static void validateNumLength(int number) {
        int length = (int) (Math.log10(number) + 1);
        if (length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOneToNine(int number) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        while (number != 0) {
            int digit = number % 10;
            if (!numList.contains(digit)) {
                throw new IllegalArgumentException();
            }
            number /= 10;
        }
    }

    private static void validateNotDuplicate(int number) {
        List<Integer> numList = new ArrayList<>();

        while (number != 0) {
            int digit = number % 10;
            if (numList.contains(digit)) {
                throw new IllegalArgumentException();
            }
            numList.add(digit);
            number /= 10;
        }
    }


    public static int generateOpponentNumber() {
        List<Integer> numList = new ArrayList<>();

        while (numList.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }

        int opponentNumber = numListToThreeDigits(numList);

        return opponentNumber;
    }


    private static List<Integer> threeDigitsToNumList(int number) {
        List<Integer> eachDigits = new ArrayList<>();

        int denominator = 100;
        for (int index = 0; index < 3; index++) {
            eachDigits.add(number / denominator);

            number %= denominator;
            denominator /= 10;
        }
        return eachDigits;
    }

    private static int numListToThreeDigits(List<Integer> eachDigits) {
        int threeDigits = 0;
        for (int index = 0; index < 2; index++) {
            threeDigits += eachDigits.get(index);
            threeDigits *= 10;
        }
        threeDigits += eachDigits.get(2);

        return threeDigits;
    }

}
