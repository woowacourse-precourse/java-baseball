package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static String generateRandomNumber() {
        String randomNumber = "";
        while (randomNumber.length() < 3) {
            String randomDigit = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!randomNumber.contains(randomDigit)) {
                randomNumber = randomNumber + randomDigit;
            }
        }
        return randomNumber;
    }

    public static void validateInputNumber(String inputNumber) {
        if (inputNumber.length() != 3 || !isAllInRange(inputNumber) || !isAllUnique(inputNumber)) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }
    }

    public static boolean isAllInRange(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static int checkStrike(String randomNumber, String inputNumber) {
        int result = 0;
        for (int i = 0; i < randomNumber.length(); i++) {
            if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static int checkBall(String randomNumber, String inputNumber) {
        int result = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            String currentCharacter = Character.toString(inputNumber.charAt(i));
            if (randomNumber.contains(currentCharacter) && randomNumber.charAt(i) != inputNumber.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static boolean isAllUnique(String number) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            hashSet.add(Character.toString(number.charAt(i)));
        }
        if (hashSet.size() != number.length()) {
            return false;
        }
        return true;
    }

    public static void printResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public static void playGame(String randomNumber) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            validateInputNumber(inputNumber);
            int ballCount = checkBall(randomNumber, inputNumber);
            int strikeCount = checkStrike(randomNumber, inputNumber);
            printResult(ballCount, strikeCount);
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
