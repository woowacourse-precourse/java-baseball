package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private List<Integer> computerNum;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;

    public Computer(){
        setComputerNum();
    }

    public List<Integer> getComputerNum(){
        return computerNum;
    }

    public void setComputerNum(){
        computerNum = randomNum();
    }

    public List<Integer> randomNum(){
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, 3);
    }
}
