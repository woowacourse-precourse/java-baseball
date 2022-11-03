package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefenceNumberMaker {

    int gameNumberSize;

    public List<Integer> defenceNumber;

    DefenceNumberMaker(int size) {
        defenceNumber = new ArrayList<>();
        this.gameNumberSize = size;
    }

    private void createDefenceNumber(int size) {
        defenceNumber.clear();
        while(defenceNumber.size() < size) {
            int random = Randoms.pickNumberInRange(1, 9);
            checkOverlapAndAdd(random);
        }
    }

    private void checkOverlapAndAdd(int target) {
        if(!defenceNumber.contains(target)) {
            defenceNumber.add(target);
        }
    }

    public List<Integer> getDefenceNumber() {
        createDefenceNumber(gameNumberSize);
        return defenceNumber;
    }
}
