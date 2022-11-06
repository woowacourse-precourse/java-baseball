package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    private List<Integer> computerNum;

    public Computer(int digit, int startRange, int endRange) {
        pickComputerNum(digit, startRange, endRange);
    }

    private void pickComputerNum(int digit, int startRange, int endRange) {
        computerNum = new ArrayList<>();
        while (computerNum.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(startRange, endRange);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }
}