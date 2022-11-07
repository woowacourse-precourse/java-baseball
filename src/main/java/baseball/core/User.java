package baseball.core;

import baseball.console.GameConsole;

import java.util.List;

public class User {

    private List<Integer> threeNumbers;

    public void inputThreeNumbers(GameConsole console) {
        this.threeNumbers = console.inputThreeNumbers();
    }

    public List<Integer> sayThreeNumbers() {
        return threeNumbers;
    }
}
