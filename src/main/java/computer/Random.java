package computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            boolean isUnique = isUnique(pickedNumber, randomNumber);
            if (isUnique) {
                randomNumber.add(pickedNumber);
            }
        }
        return randomNumber;
    }

    public static boolean isUnique(int pickedNumber, List<Integer> randomNumber) {
        for (int num : randomNumber) {
            if (num == pickedNumber) {
                return false;
            }
        }
        return true;
    }
}
