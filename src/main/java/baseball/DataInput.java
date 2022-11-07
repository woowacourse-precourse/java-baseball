package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DataInput {
    public static final int ONE_INPUT = 0;
    public static final int THREE_INPUT = 1;
    private String inputString;
    private final ErrorCheck errorCheck;

    DataInput(ErrorCheck errorCheck) {
        this.errorCheck = errorCheck;
    }

    public void inputNumber() {
        this.inputString = Console.readLine();
        errorCheck.launchErrorCheck(this.inputString);
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
