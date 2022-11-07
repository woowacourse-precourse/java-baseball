package baseball.dto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = new ArrayList<>();
    }

    public Computer(List<Integer> numberList) {
        this.computerNumber = numberList;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
