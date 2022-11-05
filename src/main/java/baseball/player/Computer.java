package baseball.player;

import static baseball.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> problem;

    /**
     * 문제를 생성하는 기능
     */
    public void createProblem() {
        problem = new ArrayList<>();
        while(checkNumLength()){
            int num = createRandomNum();
            if(checkOverlap(num)){
                continue;
            }
            problem.add(num);
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
        return problem.contains(num);
    }

    /**
     * 길이가 3인지 검증하는 기능
     */
    public boolean checkNumLength() {
        return problem.size() == NUM_LENGTH;
    }
}
