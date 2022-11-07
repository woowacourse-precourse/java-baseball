package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {
    List<Integer> randomNumberList = new ArrayList<>();
    public List<Integer> generateRandomNumber() {
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            inspectList(randomNumber);
        }

        return randomNumberList;
    }

    private void inspectList(int number) {
        if (!randomNumberList.contains(number)) {
            randomNumberList.add(number);
        }
    }
}
