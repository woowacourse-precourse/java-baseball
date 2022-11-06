package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNum = new ArrayList<>();

    public ComputerNumber(List<Integer> computerNum) {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        this.computerNum = computerNumberGenerator.numGenerate(computerNum);
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }

}