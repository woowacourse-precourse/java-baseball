package baseball;

import java.util.List;

public class Decision {
    public static final int MAX_STRIKE = 3;

    public int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strike = 0;

        for (int index = 0; index < userNumbers.size(); index++) {

            if (userNumbers.get(index).equals(computerNumbers.get(index))) {
                strike++;
            }
        }

        return strike;
    }

    public int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ball = 0;

        for (int index = 0; index < userNumbers.size(); index++) {
            Integer userNumber = userNumbers.get(index);
            Integer computerNumber = computerNumbers.get(index);
            if (!userNumber.equals(computerNumber) && computerNumbers.contains(userNumber)) {
                ball++;
            }
        }

        return ball;
    }

    public boolean isThreeStrike(int strike) {
        return strike == MAX_STRIKE;
    }
}
