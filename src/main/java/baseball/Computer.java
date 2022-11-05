package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    List<Integer> computerNumber;

    public Computer(List<Integer> computer) {
        this.computerNumber = computer;
    }

    public void random3NumberOutput() {

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
}
