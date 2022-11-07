package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private List<Integer> computerNum;

    public Computer(){
        setComputerNum();
    }

    public List<Integer> getComputerNum(){
        return computerNum;
    }
}
