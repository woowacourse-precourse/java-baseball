package baseball.service;

import baseball.util.Input;

import java.util.List;
import java.util.Map;

public class Set {

    List<String> computerAnswer;
    List<String> userAnswer;
    Input input = new Input();

    public Set(List<String> computerAnswer) {
        this.computerAnswer = computerAnswer;
    }

    public void inputUserAnswer() {
        userAnswer = input.inputNumber();
    }

    public Map<String, Integer> calculate() {
        Calculator calculator = new Calculator(Set.this);
        calculator.calculate();
        return calculator.getResult();
    }

    public boolean inputReplayAnswer() {
        String retry = input.inputReplayAnswer();
        return retry.equals(GameCommand.RETRY.getCommand());
    }

}
