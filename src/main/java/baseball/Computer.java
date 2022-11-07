package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class Computer {
    private static final Integer BASEBALL_LIST_SIZE = 3;
    private BaseballList baseballList;

    public void setComputerBaseballList(){
        this.baseballList = new BaseballList(Randoms.pickUniqueNumbersInRange(1,9,3));
    }

    public void getComputerBaseballList(){
        this.baseballList.printBaseballList();
    }
    public int getStrikes(BaseballList userBaseballList) {
        return (int) IntStream.range(0, BASEBALL_LIST_SIZE)
                .filter(i -> this.baseballList.getBaseballByIndex(i).equals(userBaseballList.getBaseballByIndex(i)))
                .count();
    }
}
