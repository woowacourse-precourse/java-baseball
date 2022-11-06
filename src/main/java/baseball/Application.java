package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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
}
