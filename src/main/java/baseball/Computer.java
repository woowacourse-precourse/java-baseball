package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private static final Integer BASEBALL_LIST_SIZE = 3;
    private BaseballList baseballList;

    public void setComputerBaseballList(){
        List<Integer> computerBaseballList = new ArrayList<>();
        while (computerBaseballList.size() < BASEBALL_LIST_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseballList.contains(randomNumber)) {
                computerBaseballList.add(randomNumber);
            }
        }
        this.baseballList = new BaseballList(computerBaseballList);
    }

    public void printComputerBaseballList(){
        this.baseballList.printBaseballList();
    }
    public int getStrikes(BaseballList userBaseballList) {
        return (int) IntStream.range(0, BASEBALL_LIST_SIZE)
                .filter(i -> this.baseballList.getBaseballByIndex(i).equals(userBaseballList.getBaseballByIndex(i)))
                .count();
    }
    public int getBalls(BaseballList userBaseballList) {
        return (int) IntStream.range(0, BASEBALL_LIST_SIZE)
                .filter(i -> !this.baseballList.getBaseballByIndex(i).equals(userBaseballList.getBaseballByIndex(i)))
                .filter(i -> this.baseballList.contains(userBaseballList.getBaseballByIndex(i)))
                .count();
    }
}
