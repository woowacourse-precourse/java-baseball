package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.NumberProperty.*;

public class Computer {

    private final List<Integer> computer;

    public Computer() {
        computer = new ArrayList<Integer>();
        while (computer.size() < SIZE.get()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM.get(), MAX_NUM.get());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputer() {
        return computer;
    }
}