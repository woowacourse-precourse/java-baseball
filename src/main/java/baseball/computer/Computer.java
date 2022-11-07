package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNum = new ArrayList<>();;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;
    private static final int RANDOM_NUM_LENGTH = 9;

    public Computer(){
        createRandomNum();
    }

    public List<Integer> getComputerNum(){
        return computerNum;
    }

    public void createRandomNum(){
        while(computerNum.size() != RANDOM_NUM_LENGTH){
            int number = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!computerNum.contains(number)){
                computerNum.add(number);
            }
        }
    }

}
