package baseball.domain;

import static baseball.utils.Constant.GAME_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefenceNumberMaker {

    public List<Integer> defenceNumber;

    public DefenceNumberMaker() {
        defenceNumber = new ArrayList<>();
    }

    private void createDefenceNumber() {
        defenceNumber.clear();
        while(defenceNumber.size() < GAME_NUMBER_SIZE) {
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
        createDefenceNumber();
        return defenceNumber;
    }
}
