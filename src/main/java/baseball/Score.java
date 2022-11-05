package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Score {
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;
    public int strike = 0;
    public int ball = 0;

    public void setComputerAndUser(List<Integer> computer, List<Integer> user) {
        this.computerNumbers = computer;
        this.userNumbers = user;
    }

    public void getStrike() {
        for (int i=0; i<NUMBERS_LENGTH; i++) {
            if (isStrike(computerNumbers.get(i), userNumbers.get(i))) {
                strike += 1;
            }
        }
    }

    public void getBall() {
        for (int i=0; i<NUMBERS_LENGTH; i++) {
            if (isBall(computerNumbers, userNumbers.get(i))) {
                ball += 1;
            }
        }
    }

    public boolean isStrike(Integer computerNumber, Integer userNumber) {
        return computerNumber.equals(userNumber);
    }

    public boolean isBall(List<Integer> computerNumbers, Integer userNumber) {
        return computerNumbers.contains(userNumber);
    }
}
