package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    public Computer() {}

    private List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void setRandomNumber() {
        List<Integer> computer = createRandomNumber();
        this.randomNumber = computer;
    }
    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public int getFirstRandomNumber() {
        return randomNumber.get(0);
    }

    public int getSecondRandomNumber() {
        return randomNumber.get(1);
    }

    public int getThirdRandomNumber() {
        return randomNumber.get(2);
    }
}
