package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Target {
    private List<Integer> targetNumberList;

    public Target() {
        this.targetNumberList = new ArrayList<>(Arrays.asList(0, 0, 0));
    }

    public Target(List<Integer> testTargetNumberList) {
        this.targetNumberList = testTargetNumberList;
    }

    public void reset() {
        setTargetIntoZeroList();
        for (int indexOfList = 0; indexOfList < 3; indexOfList++) {
            setOneNumber(indexOfList);
        }
    }

    public List<Integer> get() {
        return this.targetNumberList;
    }

    void setTargetIntoZeroList() {
        for (int i = 0; i < 3; i++) {
            this.targetNumberList.set(i, 0);
        }
    }

    void setOneNumber(int indexOfList) {
        boolean isInTargetNumberList = true;
        int randomNumber = 0;
        while (isInTargetNumberList) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            isInTargetNumberList = checkIsNumberInTargetList(randomNumber);
        }
        this.targetNumberList.set(indexOfList, randomNumber);
    }

    boolean checkIsNumberInTargetList(int number) {
        return this.targetNumberList.contains(number);
    }

}
