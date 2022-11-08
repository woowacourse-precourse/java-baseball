package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    /**
     * 1 computer (상대방) 난수 생성
     * */
    static List<Integer> generateRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
