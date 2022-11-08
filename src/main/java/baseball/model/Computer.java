package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNum = new ArrayList<>();

    public void setComputerNum() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        this.computerNum = computerNumberGenerator.numGenerate(computerNum);
    }

    public List<Integer> getComputerNum() {
        setComputerNum();
        return computerNum;
    }

}