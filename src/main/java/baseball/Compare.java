package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class Compare {
    List<Integer> userNumbers;
    List<Integer> computerNumbers;

    Compare(List<Integer> computer, List<Integer> user) {
        this.computerNumbers = computer;
        this.userNumbers = user;
    }

    public boolean isStrike(Integer computerNumber, Integer userNumber) {
        return computerNumber.equals(userNumber);
    }

    public boolean isBall(List<Integer> computerNumbers, Integer userNumber) {
        return computerNumbers.contains(userNumber);
    }
}
