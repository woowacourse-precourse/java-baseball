package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    final static int ANSWER_SIZE = 3;
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
