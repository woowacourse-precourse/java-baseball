package baseball.Number;

import java.util.ArrayList;
import java.util.List;

public class MakeInputNumberList {
    private List<Integer> inputNumberList;

    public void makeInputNumberList(String inputNumber) {
        List<Integer> inputNumberList = new ArrayList<>();
        String[] inputNumberarr = inputNumber.split("");

        for (int digit = 0; digit < inputNumberarr.length; digit++) {
            inputNumberList.add(Integer.valueOf(inputNumberarr[digit]));
        }
        this.inputNumberList = inputNumberList;
    }

    public List<Integer> getInputNumberList() {
        return inputNumberList;
    }
}