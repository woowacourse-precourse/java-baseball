package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class CreateRandom {
    public static int[] makeRandomNums() {
        int random;
        int[] randomNumbers = new int[3];
        int i = 0;

        while (i < 3) {
            random = pickNumberInRange(0, 9);
            boolean check = checkIfDuplicatedNumber(random,randomNumbers);
            if (check) continue;

            randomNumbers[i] = random;
            i++;
        }

        return randomNumbers;
    }

    private static boolean checkIfDuplicatedNumber(int random, int[] randomNumbers) {
        for(int i = 0 ; i < 3; i++ ) {
            if (randomNumbers[i] == random) {
                return true;
            }
        }
        return false;
    }
}
