package baseball.user.domain;

import java.util.List;

public class User {
    private List<Integer> inputNumber;

    public List<Integer> getInputNumber() {
        return inputNumber;
    }
    public void updateInputNumber(List<Integer> inputNumber){
        this.inputNumber=inputNumber;
    }
}
