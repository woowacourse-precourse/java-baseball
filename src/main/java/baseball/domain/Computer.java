package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final int ANSWER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private List<Integer> computerAnswer;

    public Computer() {
        this.computerAnswer = new ArrayList<>();
        computerNumberDecide(computerAnswer);
    }

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public void computerNumberDecide(List<Integer> computerAnswer) {
        while (computerAnswer.size() < ANSWER_SIZE) {
            newRandomNumber(computerAnswer);
        }
    }

    public void newRandomNumber(List<Integer> computerAnswer) {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (!computerAnswer.contains(randomNumber)) {
            computerAnswer.add(randomNumber);
        }
    }

}
