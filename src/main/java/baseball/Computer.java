package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber;
    int ball;
    int strike;

    public void countBall(List<Integer> userInputNumber) {
        int ball = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.contains(userInputNumber.get(i)) && !(computerNumber.get(i).equals(userInputNumber.get(i)))) {
                ball++;
            }
        }
        this.ball = ball;
    }

    public void makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        this.computerNumber = computerNumber;
    }
}
