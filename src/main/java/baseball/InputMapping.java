package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputMapping {
    public List<Integer> getGameNumberList() {
        int inputNumber = getConsoleInt();
        if (nonValidateGameNumber(inputNumber))
            throw new IllegalArgumentException("nonValidateInputNumber");
        List<Integer> getInputNumberList = new ArrayList<>();
        while (inputNumber > 0) {
            getInputNumberList.add(inputNumber % 10);
            inputNumber /= 10;
        }
        return getInputNumberList;
    }

    public int getRestartFlag(){
        int restartFlag = getConsoleInt();
        if (restartFlag != 1 && restartFlag != 2){
            throw new IllegalArgumentException();
        }
        return restartFlag;
    }

    private int getConsoleInt() {
        try {
            String line = Console.readLine();
            if (line.isBlank() || !line.matches("\\d+"))
                throw new IllegalArgumentException();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("out of Int");
        }
    }

    private boolean nonValidateGameNumber(int inputNumber) {
        if (inputNumber < 111 || inputNumber > 999)
            return true;
        while (inputNumber > 0) {
            if (inputNumber % 10 == 0) {
                return true;
            }
            inputNumber /= 10;
        }
        return false;
    }
}
