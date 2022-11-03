package baseball.Number;

import java.util.List;

public class NumberListRepository {
    private List<Integer> RandomNumberList;
    private List<Integer> InputNumberList;

    public List<Integer> getRandomNumberList() {
        return RandomNumberList;
    }

    public void setRandomNumberList(List<Integer> randomNumberList) {
        RandomNumberList = randomNumberList;
    }

    public List<Integer> getInputNumberList() {
        return InputNumberList;
    }

    public void setInputNumberList(List<Integer> inputNumberList) {
        InputNumberList = inputNumberList;
    }
}
