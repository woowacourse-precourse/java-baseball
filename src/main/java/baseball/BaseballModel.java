package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class BaseballModel {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int ARRAY_SIZE = 3;

    ArrayList<Integer> targetNumbers = new ArrayList<>();

    public ArrayList<Integer> getTargetNumbers() {
        return targetNumbers;
    }

    private void removeTargetNumberList() {
        targetNumbers.clear();
    }

    public void createTargetNumberList() {

        if(targetNumbers.size() > 0) {
            removeTargetNumberList();
        }

        while (targetNumbers.size() < ARRAY_SIZE) {
            overlapNumberInNumberList(Randoms.pickNumberInRange(MIN_NUM,MAX_NUM));
        }
    }

    private void overlapNumberInNumberList(int number) {
        if(targetNumbers.contains(number)) {
            return;
        }

        targetNumbers.add(number);
    }

    //// TODO: 2022-11-07  배열 생성에 관한 예외처리
}
