package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = new ArrayList<>();
    }

    public void makeRandom() {
        computerNumber.clear();

        while(this.computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!this.computerNumber.contains(randomNumber)) { //중복 방지
                this.computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        List<Integer> computerNum = new ArrayList<>();

        for (int idx = 0; idx < 3; idx++) {
            computerNum.add(this.computerNumber.get(idx));
        }
        return computerNum;
    }
}
