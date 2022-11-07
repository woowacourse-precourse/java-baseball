package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerUtil {

    private ComputerUtil() {
    }

    public static List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(List.of(0, 0, 0));

        for (int i = 0; i < 3; i++) {
            int validRandomNumber = getValidRandomNumber(computerNumbers);

            computerNumbers.set(i, validRandomNumber);
        }

        return computerNumbers;
    }

    private static int getValidRandomNumber(List<Integer> computerNumbers) {
        while (true) {
            int randomNumber = getRandomNumber();

            if (isValidNumber(computerNumbers, randomNumber)) {
                return randomNumber;
            }
        }
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private static boolean isValidNumber(List<Integer> computerNumbers, int randomNumber) {
        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            if (isEmpty(computerNumber)) {
                break;
            }

            if (hasSameNumber(computerNumber, randomNumber)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isEmpty(int computerNumber) {
        return computerNumber == 0;
    }

    private static boolean hasSameNumber(int computerNumber, int randomNumber) {
        return computerNumber == randomNumber;
    }
}
