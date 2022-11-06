package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> inputList;
        DataInput input = new DataInput();
        DataProcessing process = new DataProcessing();

        inputList = input.getInputValue();
        process.setData(inputList);
        process.getProcessedData();
    }
}
