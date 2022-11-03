package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createDefenseNumber() {
        List<Integer> defenseNumber = new ArrayList<>();
        while (defenseNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // TODO: 랜덤한 숫자가 리스트에 없는 숫자일 경우 리스트에 추가하는 기능
        }
        return defenseNumber;
    }
}
