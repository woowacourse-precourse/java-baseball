package baseball.player;

import static baseball.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNum;

    /**
     * 문제를 생성하는 기능
     */
    public void createProblem() {
        randomNum = new ArrayList<>();
        while(checkNumLength()){
            int num = createRandomNum();
            if(checkOverlap(num)){
                continue;
            }
            randomNum.add(num);
        }
    }

    /**
     * 랜덤한 수를 생성하는 기능
     */
    public int createRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    /**
     * 중복된 수가 있는지 검증하는 기능
     */
    public boolean checkOverlap(int num) {
        return randomNum.contains(num);
    }

    /**
     * 길이가 3인지 검증하는 기능
     */
    public boolean checkNumLength() {
        return randomNum.size() == NUM_LENGTH;
    }
}
