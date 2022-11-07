package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerUtil {
    public static List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(List.of(0, 0, 0));

        for (int i = 0; i < 3; i++) {
            int randomNumber = getRandomNumber();

            computerNumbers.add(i, randomNumber);
        }

        return computerNumbers;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
