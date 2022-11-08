package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    static final int NUM_LEN = 3;

    protected List<Integer> target;

    /**
     * 컴퓨터의 중복되지 않는 3자리 Random 값을 생성하는 함수
     */
    public void generateTarget(){
        while(target.size() < 3){
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!target.contains(randomNum)) {
                target.add(randomNum);
            }
        }
    }

}
