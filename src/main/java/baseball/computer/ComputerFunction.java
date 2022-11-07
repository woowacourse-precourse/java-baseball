package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerFunction {

    public List<Integer> createRandomList() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            int randomNum = getRandomNumber();
            checkAddNumber(list, randomNum);
        }
        return list;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean collectionListCheckValue(int value, List<Integer> list) {
        return list.contains(value);
    }

    private void checkAddNumber(List<Integer> list, int randomNum) {
        if (!collectionListCheckValue(randomNum, list)) {
            list.add(randomNum);
        }
    }
}
