package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> inputNumberList = new ArrayList<>();
    private int inputNumber;

    public void input() {
        String inputString;
        inputString = Console.readLine();
        setInputNumber(Integer.parseInt(inputString));
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }
}
