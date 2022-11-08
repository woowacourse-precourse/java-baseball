package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;

    public List<Integer> getNumber() {
        return number;
    }

    public Computer(){
        number = this.make3RandomNumber();
    }
    private List<Integer> make3RandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < BaseBall.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
