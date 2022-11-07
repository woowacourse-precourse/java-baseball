package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerUtil {

    public static List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(List.of(0, 0, 0));

        for (int i = 0; i < 3; i++) {
            int validRandomNumber = getValidRandomNumber(computerNumbers);

            computerNumbers.add(i, validRandomNumber);
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
            if (computerNumber == 0) {
                break;
            }

            if (computerNumber == randomNumber) {
                return false;
            }
        }

        return true;
    }
}
