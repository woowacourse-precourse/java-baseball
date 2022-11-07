package baseball;

import java.util.ArrayList;

public class Application {
    public static final int ONE_INPUT = 0;
    public static final int THREE_INPUT = 1;
    private static final DataInput input = new DataInput();
    private static final DataProcessing process = new DataProcessing();
    private static final OutputPrint print = new OutputPrint();

    private static void inGame() {
        ArrayList<Integer> inputList;
        int[] processedData;

        process.makeRandomData();
        do {
            print.printRequest();
            input.inputNumber(THREE_INPUT);
            inputList = input.getInputValue();
            process.setData(inputList);
            processedData = process.getProcessedData();
            print.printGameResult(processedData);
        } while(processedData[0] != 3);
    }

    private static void gameStart() {
        ArrayList<Integer> inputList;

        print.printStart();
        do {
            inGame();
            print.printWin();
            print.printRestart();
            input.inputNumber(ONE_INPUT);
            inputList = input.getInputValue();
        } while (inputList.get(0) == 1);
    }

    public static void main(String[] args) {
        gameStart();
    }
}
