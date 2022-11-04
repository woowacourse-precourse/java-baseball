package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerAnswer;

    Computer() {
        this.computerAnswer = setComputerAnswer();
    }

    public List<Integer> setComputerAnswer() {
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            addNewDigit(computerAnswer);
        }
        return computerAnswer;
    }

    public List<Integer> addNewDigit(List<Integer> computerAnswer) {
        Integer newDigit = Randoms.pickNumberInRange(1, 9);
        if (!computerAnswer.contains(newDigit)) {
            computerAnswer.add(newDigit);
        }
        return computerAnswer;
    }
    

    public String getHint (String playerAnswer) {
        //TODO
        return "";
    }
}
