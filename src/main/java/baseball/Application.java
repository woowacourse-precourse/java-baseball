package baseball;

import java.util.ArrayList;

public class Application {
    public static final int ONE_INPUT = 0;
    public static final int THREE_INPUT = 1;

    private static void inGame() {
        ArrayList<Integer> inputList;
        int[] processedData;
        DataInput input = new DataInput();
        DataProcessing process = new DataProcessing();
        OutputPrint print = new OutputPrint();

        while (true) {
            print.printRequest();
            input.inputNumber(THREE_INPUT);
            inputList = input.getInputValue();
            process.setData(inputList);
            processedData = process.getProcessedData();
            print.printGameResult(processedData);
            if (processedData[0] == 3) {    //세가지 숫자와 위치를 다 맞춰 게임이 끝났을 때
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
            input.inputNumber(ONE_INPUT);
            inputList = input.getInputValue();
            if (inputList.get(0) == 2) {    //게임 진행의사가 없어서 게임을 아예 종료 시킬 때
                break;
            }
        }
    }

    public static void main(String[] args) {
        gameStart();
    }
}
