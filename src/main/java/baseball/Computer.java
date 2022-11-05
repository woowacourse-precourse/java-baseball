package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<Integer> computerNumberList;
    static final int NUMBER_LENGTH = 3;

    Computer() {
        computerNumberList = this.makeNumberList();
    }

    private List<Integer> makeNumberList() {
        List<Integer> computerNumberList = new ArrayList<>(NUMBER_LENGTH);
        while (computerNumberList.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberIfNotList(computerNumberList, randomNumber);
        }
        return computerNumberList;
    }

    private void addNumberIfNotList(List<Integer> computerNumberList, int randomNumber) {
        if (!computerNumberList.contains(randomNumber)) {
            computerNumberList.add(randomNumber);
        }
    }
}
