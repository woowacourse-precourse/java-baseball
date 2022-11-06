package baseball;

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
}
