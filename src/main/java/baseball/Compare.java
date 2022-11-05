package baseball;

import java.util.Arrays;
import java.util.List;

import static baseball.Constant.*;

public class Compare {
    List<Integer> userNumbers;
    List<Integer> computerNumbers;

    Compare(List<Integer> computer, List<Integer> user) {
        this.computerNumbers = computer;
        this.userNumbers = user;
    }

    public List<Integer> CountScore() {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<PLAYING_NUMBERS_LENGTH; i++) {
            if (isStrike(computerNumbers.get(i), userNumbers.get(i))) {
                strike += 1;
            }
            if (isBall(computerNumbers, userNumbers.get(i))) {
                ball += 1;
            }
        }
        return Arrays.asList(strike, ball);
    }

    public boolean isStrike(Integer computerNumber, Integer userNumber) {
        return computerNumber.equals(userNumber);
    }

    public boolean isBall(List<Integer> computerNumbers, Integer userNumber) {
        return computerNumbers.contains(userNumber);
    }
}
