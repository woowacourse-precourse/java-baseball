package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numList;

    public Computer() {
    }

    public void createNumList() {
        List<Integer> computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            if (!computerNumList.contains(randomNum)) {
                computerNumList.add(randomNum);
            }
        }
        this.numList = computerNumList;
    }

    public List<Integer> getNumList() {
        return numList;
    }
}
