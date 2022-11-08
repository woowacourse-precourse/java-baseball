package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Computer {
    List<Integer> computer;

    public Computer() {
        this.computer = new ArrayList<>();
    }

    List<Integer> computerNumber() {
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
