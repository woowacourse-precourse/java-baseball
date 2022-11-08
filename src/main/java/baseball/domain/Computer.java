package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int ANSWER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final List<Integer> computerAnswer;

    public Computer() {
        this.computerAnswer = new ArrayList<>();
        computerNumberDecide();
    }

    public List<Integer> getComputerAnswer() {
        return this.computerAnswer;
    }

    public void computerNumberDecide() {
        while (this.computerAnswer.size() < ANSWER_SIZE) {
            newRandomNumber();
        }
    }

    public void newRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (!this.computerAnswer.contains(randomNumber)) {
            this.computerAnswer.add(randomNumber);
        }
    }

}
