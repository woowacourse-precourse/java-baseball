package baseball.Number;

import java.util.ArrayList;
import java.util.List;

public class MakeInputNumberList {
    private List<Integer> inputNumberList;

    public MakeInputNumberList() {
        InputNumber input = new InputNumber();
        String[] inputNumber = input.getInputnumber().split("");
        List<Integer> inputNumberList = new ArrayList<>();

        for (int digit = 0; digit < inputNumber.length; digit++) {
            inputNumberList.add(Integer.valueOf(inputNumber[digit]));
        }
        this.inputNumberList = inputNumberList;
    }

    public List<Integer> getInputNumberList() {
        return inputNumberList;
    }

    public void setInputNumberList(List<Integer> inputNumberList) {
        this.inputNumberList = inputNumberList;
    }
}