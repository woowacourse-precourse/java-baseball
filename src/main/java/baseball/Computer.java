package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<String> computerAnswer;

    Computer() {
        setComputerAnswer();
    }

    public void setComputerAnswer() {
        List<String> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            addNewDigit(computerAnswer);
        }
        this.computerAnswer = computerAnswer;
    }

    public void addNewDigit(List<String> computerAnswer) {
        String newDigit = Integer.toString(Randoms.pickNumberInRange(1, 9));
        if (!computerAnswer.contains(newDigit)) {
            computerAnswer.add(newDigit);
        }
    }

    public List<String> giveHint (List<String> playerAnswer) {
        List<String> ballAndStrike = new ArrayList<>();

        return ballAndStrike;
    }
}
