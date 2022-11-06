package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber = new ArrayList<>();

    public void generateRandomNumber() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            inspectList(randomNumber);
        }
    }

    public void inspectList(int number) {
        if (!computerNumber.contains(number)) {
            computerNumber.add(number);
        }
    }
}
