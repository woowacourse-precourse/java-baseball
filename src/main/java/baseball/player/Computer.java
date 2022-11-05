package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {

    private List<Integer> randomNum;

    /**
     * 랜덤한 수를 생성하는 기능
     */
    public int createRandomNum() {
        return Randoms.pickNumberInRange(1, 9);
    }

    /**
     * 중복된 수가 있는지 검증하는 기능
     */
    public boolean checkOverlap(int num) {
        return randomNum.contains(num);
    }
}
