package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class DataInput {
    public static final int ONE_INPUT = 0;
    public static final int THREE_INPUT = 1;
    private String inputString;

    public void inputNumber(int type) {
        this.inputString = Console.readLine();

        if (type == ONE_INPUT) {
            ErrorCheck errorCheck = new OneValueCheckError(this.inputString);
            errorCheck.launchErrorCheck();
        }
        if (type == THREE_INPUT) {
            ErrorCheck errorCheck = new ThreeValueCheckError(this.inputString);
            errorCheck.launchErrorCheck();
        }
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
        result = makeIntegerList();
        return result;
    }
}
