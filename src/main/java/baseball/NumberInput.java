package baseball;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberInput {

    protected List<Integer> inputNumber;
    protected int inputLength;
    protected List<Integer> allowedNumbers;

    protected NumberInput(String input) {
        inputNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(input.charAt(i) - '0');
        }
    }
    protected void checkingLength() {
        if (inputNumber.size() != inputLength) {
            makingError();
        }
    }
    protected void checkingNumbers() {
        for(int number : inputNumber){
            if(!allowedNumbers.contains(number)){
                makingError();
            }
        }
    }
    protected void makingError(){
        throw new IllegalArgumentException();
    }
    public abstract void errorChecking();
}
