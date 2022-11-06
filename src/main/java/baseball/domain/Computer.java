package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private List<Integer> computerAnswer;

    public Computer() {
        this.computerAnswer = new ArrayList<>();
    }

    public Computer(List<Integer> computerAnswer) {
        this.computerAnswer = new ArrayList<>();
        this.computerAnswer.addAll(computerAnswer);
    }

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public void setComputerAnswer(List<Integer> computerAnswer) {
        this.computerAnswer = computerAnswer;
    }
}
