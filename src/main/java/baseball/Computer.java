package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static void createRandomNumber(List<Integer> computerNumber) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public static List<Integer> getRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            createRandomNumber(computerNumber);
        }
        return computerNumber;
    }
}
