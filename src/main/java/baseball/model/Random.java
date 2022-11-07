package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {
    private static List<Integer> randomNumber = new ArrayList<>();

    private static void generateRandomNumber() {
        randomNumber.clear();

        while (randomNumber.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (containsDigit(randomDigit)) {
                continue;
            }
            randomNumber.add(randomDigit);
        }
    }

    private static boolean containsDigit(int digit) {
        if (randomNumber.contains(digit)) {
            return true;
        }
        return false;
    }

    public static List<Integer> getRandomNumber() {
        generateRandomNumber();
        return randomNumber;
    }
}
