package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerDigits = generateRandomNumbers();

        while (answerDigits.size() == 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = getUserInput();
            int userGuess = validateUserInput(userInput, 3);

            List<Integer> inputDigits = getDigitList(userGuess);
            List<Integer> comparedResult = compareAnswerWithInput(answerDigits, inputDigits);

            boolean isGameFinished = printHint(comparedResult);

            if (isGameFinished) {
                userInput = getUserInput();
                userGuess = validateUserInput(userInput, 1);
                answerDigits = toBeContinued(userGuess, answerDigits);
            }
        }

        return;
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> answerDigits = new ArrayList<Integer>();
        while (answerDigits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerDigits.contains(randomNumber)) {
                answerDigits.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        System.out.println();
        return answerDigits;
    }

    public static String getUserInput() {
        String userInput = Console.readLine();
        System.out.println(userInput);

        return userInput;
    }

    private static int validateUserInput(String userInput, int checkLength) throws IllegalArgumentException {
        try {
            if (userInput.length() != checkLength) {
                throw new IllegalArgumentException("Input length should be" + checkLength);
            }

            if (userInput.contains("0")) {
                throw new IllegalArgumentException("every digit is in the range of 1~9");
            }

            int userGuess = Integer.parseInt(userInput);

            return userGuess;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("every digit is in the range of 1~9");
        }
    }

    public static List<Integer> compareAnswerWithInput(List<Integer> answerDigits, List<Integer> inputDigits) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            int answerDigit = answerDigits.get(i);
            int inputDigit = inputDigits.get(i);

            if (answerDigit == inputDigit) {
                strikeCount++;
                ballCount--;
            }
            if (answerDigits.contains(inputDigit)) {
                ballCount++;
            }
        }

        return List.of(strikeCount, ballCount);
    }

    public static List<Integer> getDigitList(int numbers) {
        int tmp = numbers;
        ArrayList<Integer> digits = new ArrayList<Integer>();

        while (tmp > 0) {
            int digit = tmp % 10;
            checkDuplicate(digits, digit);
            digits.add(0, digit);
            tmp = tmp / 10;
        }

        return digits;
    }

    public static void checkDuplicate(List<Integer> digits, int digit) {
        if (digits.contains(digit)) {
            throw new IllegalArgumentException("Duplicate digit exists");
        }
        return;
    }

    public static boolean printHint(List<Integer> comparedResult) {
        int strikeCount = comparedResult.get(0);
        int ballCount = comparedResult.get(1);

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        System.out.println("");
        return false;
    }

    public static List<Integer> toBeContinued(int userInput, List<Integer> answerDigits) {
        checkInRange(userInput, 1, 2);

        if (userInput == 1) {
            answerDigits = generateRandomNumbers();
        } else if (userInput == 2) {
            answerDigits = Collections.EMPTY_LIST;
        }

        return answerDigits;
    }

    public static void checkInRange(int userInput, int from, int to) {
        if (userInput < from || userInput > to) {
            throw new IllegalArgumentException("Wrong input range");
        }
        return;
    }
}
