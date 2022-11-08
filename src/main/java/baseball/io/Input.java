package baseball.io;

import baseball.exception.InputNotNumberOrZeroException;
import baseball.exception.InputSameNumberException;
import baseball.exception.InputWrongNumberOfDigitsException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final Output output;
    private final String REGEX = "^[1-9]*$";
    private final int NUMBER_LEN = 3;
    private final String RE_GAME = "1";
    private final String END_GAME = "2";

    public Input() {
        this.output = new Output();
    }

    public List<Integer> inputUserNumber() {
        String number = inputNumber();
        checkValidationOfInputNum(number);
        List<Integer> inputNumList = changeInputNumberToList(number);
        return inputNumList;
    }

    public String inputReGameNumber() {
        String number = inputNumber();
        return number;
    }

    private String inputNumber() {
        String number = Console.readLine();
        return number;
    }

    private void checkValidationOfInputNum(String inputNum) {
        String[] numArr = inputNum.split("");
        int len = inputNum.length();
        checkUserNumLength(len);
        checkUserNumIsNumber(inputNum);
        checkUserNumDuplication(numArr, len);
    }

    private void checkUserNumLength(int len) {
        if(len != NUMBER_LEN) {
            throw new InputWrongNumberOfDigitsException();
        }
    }

    private void checkUserNumIsNumber(String inputNum) {
        if(!inputNum.matches(REGEX)) {
            throw new InputNotNumberOrZeroException();
        }
    }

    private void checkUserNumDuplication(String[] numArr, int len) {
        for(int i = 0; i < len; i++) {
            compareEachNumber(numArr, len, i);
        }
    }

    private void compareEachNumber(String[] numArr, int len, int i) {
        for(int j = i + 1; j < len; j++) {
            if(numArr[i].equals(numArr[j])) {
                throw new InputSameNumberException();
            }
        }
    }

    private List<Integer> changeInputNumberToList(String inputNum) {
        List<Integer> inputNumList = new ArrayList<>();
        String[] numArr = inputNum.split("");
        for(String num : numArr) {
            inputNumList.add(Integer.parseInt(num));
        }
        return inputNumList;
    }
}
