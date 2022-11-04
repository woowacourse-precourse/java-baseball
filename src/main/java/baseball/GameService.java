package baseball;

import java.util.List;

public class GameService {

    public Integer countStrike(List<Integer> randomNumber, List<Integer> userNumber){
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber.get(index).equals(userNumber.get(index))) {
                strike += 1;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> randomNumber, List<Integer> userNumber) {
        int strike = countStrike(randomNumber, userNumber);
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber.contains(userNumber.get(index))) {
                ball += 1;
            }
        }
        return ball - strike;
    }
}
