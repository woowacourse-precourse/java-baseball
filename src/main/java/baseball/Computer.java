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

    public List<String> giveHint(List<String> playerAnswer) {
        List<String> ballAndStrike = new ArrayList<>();

        Integer ball = getBall(playerAnswer);
        Integer strike = getStrike(playerAnswer);

        ballAndStrike.add(Integer.toString((ball - strike)));
        ballAndStrike.add(Integer.toString(strike));

        return ballAndStrike;
    }

    public Integer getBall(List<String> playerAnswer) {
        Integer ball = 0;
        for (String digit : playerAnswer) {
            ball += contained(digit);
        }
        return ball;
    }

    public Integer contained(String digit) {
        if(this.computerAnswer.contains(digit)) {
            return 1;
        }
        return 0;
    }

    public Integer getStrike(List<String> playerAnswer) {
        Integer strike = 0;
        for (int i = 0; i < 3; i++) {
            strike += correspond(playerAnswer, i);
        }
        return strike;
    }

    public Integer correspond(List<String> playerAnswer, int i) {
        if (playerAnswer.get(i).equals(this.computerAnswer.get(i))) {
            return 1;
        }
        return 0;
    }
}
