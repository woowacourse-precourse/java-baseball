package baseball;

import java.util.ArrayList;

public class Application {
    private static void inGame() {
        ArrayList<Integer> inputList;
        int[] processedData;
        DataInput input = new DataInput();
        DataProcessing process = new DataProcessing();
        OutputPrint print = new OutputPrint();

        while (true) {
            print.printRequest();
            input.inputNumber();
            inputList = input.getInputValue();
            process.setData(inputList);
            processedData = process.getProcessedData();
            print.printGameResult(processedData);
            if (processedData[0] == 3) {
                break;
            }
        }
    }

    private static void gameStart() {
        ArrayList<Integer> inputList;
        OutputPrint print = new OutputPrint();
        DataInput input = new DataInput();

        print.printStart();
        while (true) {
            inGame();
            print.printWin();
            print.printRestart();
            input.inputNumber();
            inputList = input.getInputValue();
            if (inputList.get(0) == 2) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        gameStart();
    }
}
