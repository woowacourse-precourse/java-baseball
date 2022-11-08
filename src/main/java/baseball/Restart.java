package baseball;

import static baseball.ConstantAndMessage.*;

import java.util.List;

public class Restart extends NumberInput {

    public Restart(String input) {
        super(input);
        inputLength = 1;
        allowedNumbers = List.of(RESTART_NUMBER,TERMINATION_NUMBER);
    }
    public boolean wantTerminate(){
        return inputNumber.get(0) == TERMINATION_NUMBER;
    }
    @Override
    public void errorChecking() {
        checkingLength();
        checkingNumbers();
    }
}
