package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int minNumber = 1;
    private final int maxNumber = 9;
    private final int digitNumber = 3;

    // 컴퓨터 3자리 수 만들기
    public List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < digitNumber) {
            int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
