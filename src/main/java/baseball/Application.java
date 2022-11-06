package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");


    }

    private static boolean getResult() {
        List<String> receivingNumbers = receivingValue();
        List<String> randomNumbers = createRandom();

        int strikesCount = checkStrike(receivingNumbers, randomNumbers);
        int ballCount = checkBall(receivingNumbers, randomNumbers) - strikesCount;



        return false;
    }

    private static void printResult(int strikesCount, int ballCount) {
        if (strikesCount > 0 && ballCount > 0) {
            printBallAndStrike(strikesCount, ballCount);
        } else if (strikesCount > 0) {
            justPrintStrike(strikesCount);
        } else if (ballCount > 0) {
            justPrintBall(ballCount);
        } else {
            System.out.println("낫싱");
        }
    }

    private static void printBallAndStrike(int strikesCount, int ballCount) {
        System.out.println(ballCount + "볼 " + strikesCount + "스트라이크");
    }

    private static void justPrintBall(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    private static void justPrintStrike(int strikesCount) {
        System.out.println(strikesCount + "스트라이크");
    }

    private static int checkStrike(List<String> receivingNumbers, List<String> randomNumbers) {
        int strikesCount = 0;
        for (int index = 0; index < randomNumbers.size(); index++) {
            if (receivingNumbers.get(index).equals(randomNumbers.get(index))) {
                strikesCount++;
            }
        }

        return strikesCount;
    }

    private static int checkBall(List<String> receivingNumbers, List<String> randomNumbers) {
        int ballsCount = 0;
        for (String receivingNumber : receivingNumbers) {
            if (randomNumbers.contains(receivingNumber)) {
                ballsCount++;
            }
        }

        return ballsCount;
    }

    private static List<String> createRandom() {
        List<String> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(String.valueOf(randomNumber));
        }

        return randomNumbers;
    }

    private static List<String> receivingValue() {
        String inputValue = Console.readLine();
        List<String> numbers = List.of(inputValue);

        handlingException(numbers);

        return numbers;
    }

    private static void handlingException(List<String> numbers) {
        try {
            checkValue(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("e = " + e);
        }
    }

    private static void checkValue(List<String> numbers) throws IllegalArgumentException {
        if (isIncludingZero(numbers) || isSizeOverThree(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isIncludingZero(List<String> numbers) {
        return numbers.contains("0");
    }

    private static boolean isSizeOverThree(List<String> numbers) {
        return numbers.size() > 3;
    }

}
