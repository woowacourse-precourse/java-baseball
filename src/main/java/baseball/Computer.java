package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int DIGIT = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private List<Integer> number;

    public void setNumber() {
        try {
            BaseballNumber baseballNumber = new BaseballNumber(createComputerNum());
            this.number = baseballNumber.getNumber();
        } catch (Exception e) {
            setNumber();
        }
    }

    public List<Integer> getNumber() {
        return number;
    }

    public List<Integer> createComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            computerNum.add(randomNumber);
        }
        return computerNum;
    }
}
