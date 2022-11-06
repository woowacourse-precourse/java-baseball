package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class DataInput {

    private String inputString;

    DataInput() {
        this.inputString = inputNumber();
    }

    private String inputNumber() {
        String inputString = Console.readLine();
        return inputString;
    }

    private ArrayList<Integer> makeIntegerList() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int tempValue = 0;

        for (int i = 0; i < this.inputString.length(); i++) {
            tempValue = Character.getNumericValue(this.inputString.charAt(i));
            result.add(tempValue);
        }
        return result;
    }

    public ArrayList<Integer> getInputValue() {
        ArrayList<Integer> result;
        ErrorCheck num_check = new ErrorCheck(this.inputString);

        if (num_check.launchInputCheck() == false) {
            throw new IllegalArgumentException();
        }
        result = makeIntegerList();
        return result;
    }
}
