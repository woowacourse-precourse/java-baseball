package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<String> randomNumbers;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike = 0;
        List<String> receivingNumbers;
        randomNumbers = createRandom();
        while (true) {
            receivingNumbers = receivingValue();
            checkValue(receivingNumbers);
            strike = getResult(receivingNumbers);
            if (askToUserGameAgain(strike)) {
                break;
            }
        }
    }

    private static boolean askToUserGameAgain(int strike) {
        boolean result = false;
        if (strike == 3) {
            printGameOver();

            String userAnswer = Console.readLine();
            result = checkUserAnswer(userAnswer);
        }
        return result;
    }

    private static boolean checkUserAnswer(String userAnswer) {
        if (userAnswer.equals("2")) {
            return true;
        } else if (userAnswer.equals("1")) {
            randomNumbers.clear();
            randomNumbers = createRandom();
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static int getResult(List<String> receivingNumbers) {
        int strikesCount = checkStrike(receivingNumbers);
        int ballCount = checkBall(receivingNumbers) - strikesCount;

        printResult(strikesCount, ballCount);

        return strikesCount;
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

    private static int checkStrike(List<String> receivingNumbers) {
        int strikesCount = 0;
        for (int index = 0; index < randomNumbers.size(); index++) {
            if (receivingNumbers.get(index).equals(randomNumbers.get(index))) {
                strikesCount++;
            }
        }

        return strikesCount;
    }

    private static int checkBall(List<String> receivingNumbers) {
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
            if (randomNumbers.contains(String.valueOf(randomNumber))) {
                i--;
                continue;
            }
            randomNumbers.add(String.valueOf(randomNumber));
        }

        return randomNumbers;
    }

    private static List<String> receivingValue() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();
        String[] splittingInputValue = inputValue.split("");

        return List.of(splittingInputValue);
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
