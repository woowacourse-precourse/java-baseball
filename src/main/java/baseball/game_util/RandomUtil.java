package baseball.game_util;

import static baseball.common.Constants.END_NUMBER_RANGE;
import static baseball.common.Constants.MAX_NUMBER_COUNT;
import static baseball.common.Constants.START_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static int[] createRandomComputerNumbers() {
        int[] computerNumbers = new int[MAX_NUMBER_COUNT];

        for (int i = 0; i < MAX_NUMBER_COUNT; i++) {
            computerNumbers[i] = getNotDuplicateRandomNumber(computerNumbers);
        }
        return computerNumbers;
    }

    private static int getNotDuplicateRandomNumber(int[] computerNumbers) {
        while (true) {
            int randomNumber = getRandomNumber();
            boolean checkContainNumber = checkContainNumber(computerNumbers, randomNumber);
            if (checkContainNumber) {
                return randomNumber;
            }
        }
    }

    private static boolean checkContainNumber(int[] computerNumbers, int randomNumber) {
        for (int i = 0; i < MAX_NUMBER_COUNT; i++) {
            if (computerNumbers[i] == randomNumber) {
                return false;
            }
        }
        return true;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE);
    }

}
