package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    private List<Integer> computerNum;

    public Computer() {
        pickComputerNum();
    }

    private void pickComputerNum() {
        computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }
}