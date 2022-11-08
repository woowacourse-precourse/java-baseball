package mock;

import basedomain.input.Input;
import java.util.List;

public class MockInput implements Input {

    private List<Integer> inputData;
    private int currentIndex = 0;

    public MockInput(List<Integer> inputData) {
        this.inputData = inputData;
    }

    @Override
    public int getInputInteger() {
        int currentData = inputData.get(currentIndex);
        currentIndex++;
        return currentData;
    }
}
