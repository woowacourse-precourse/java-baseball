package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> randoms() {
        List<Integer> randoms = new ArrayList<>();
        while (randoms.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randoms.contains(randomNumber)) {
                randoms.add(randomNumber);
            }
        }
        return randoms;
    }

    public String gameStart() {
        return "숫자 야구 게임을 시작합니다.";
    }
}
