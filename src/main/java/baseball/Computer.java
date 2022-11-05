package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<Integer> computerNumberList;

    Computer() {
        computerNumberList = this.makeNumberList();
    }

    private List<Integer> makeNumberList() {
        List<Integer> computerNumberList = new ArrayList<>(3);
        while (computerNumberList.size() < 3) {
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
