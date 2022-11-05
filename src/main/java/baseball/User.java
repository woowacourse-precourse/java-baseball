package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> inputNumberList = new ArrayList<>();
    private int inputNumber;

    public void input() {
        processInput();
        convertIntToList();
    }

    public void processInput() {
        String inputString;
        inputString = Console.readLine();
        setInputNumber(Integer.parseInt(inputString));
    }

    public void convertIntToList() {
        int number = getInputNumber();
        inputNumberList.add(number / 100);
        number = number % 100;
        inputNumberList.add(number / 10);
        number = number % 10;
        inputNumberList.add(number);
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public List<Integer> getInputNumberList() {
        return inputNumberList;
    }

    public void setInputNumberList(List<Integer> inputNumberList) {
        this.inputNumberList = inputNumberList;
    }
}
