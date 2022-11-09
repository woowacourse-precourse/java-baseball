package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    final static int numberLength = 3;
    private List<String> computer = new ArrayList<String>();

    public List<String> getNumber() {
        return this.computer;
    }

    public void setNumber(List<String> number) {
        this.computer = number;
    }

    public void makeRandomNumber() {
        while (computer.size() < numberLength) {
            String randomDigit = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomDigit)) {
                computer.add(randomDigit);
            }
        }
    }

    public MatchResult match(List<String> guessNumber) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.get(i).equals(this.computer.get(i))) {
                strike++;
                continue;
            }
            if (this.computer.contains(guessNumber.get(i))) {
                ball++;
            }
        }
        return new MatchResult(ball, strike);
    }
}

