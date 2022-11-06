package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static List<Integer> generateRandomNumberBySize() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < Game.NUMBER_SIZE) {
            int tempRandomNumber = generateRandomNumber();
            if (!randomNumber.contains(tempRandomNumber)) {
                randomNumber.add(tempRandomNumber);
            }
        }
        return randomNumber;
    }
}
