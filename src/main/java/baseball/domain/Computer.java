package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    final static int ANSWER_SIZE = 3;
    private List<Integer> computerAnswer;

    public Computer() {
        this.computerAnswer = new ArrayList<>();computerNumberDecide(computerAnswer);
    }

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public void setComputerAnswer(List<Integer> computerAnswer) {
        this.computerAnswer = computerAnswer;
    }

    public void computerNumberDecide(List<Integer> computerAnswer) {
        while (computerAnswer.size() < ANSWER_SIZE) {
            newRandomNumber(computerAnswer);
        }
    }

    public void newRandomNumber(List<Integer> computerAnswer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerAnswer.contains(randomNumber)) {
//            System.out.println(randomNumber);
            computerAnswer.add(randomNumber);
        }
    }

}
