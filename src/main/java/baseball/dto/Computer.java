package baseball.dto;

import java.util.List;

public class Computer {

    List<Integer> computerNumber;

    public Computer(List<Integer> numberList) {
        this.computerNumber = numberList;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
