package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int LENGTH = 3;
    private List<Integer> computerNumber = new ArrayList<>();

    private void initComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while(computerNumber.size() < LENGTH) {
            if(!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private int countStrike(List<Integer> userNumber) {
        int strike = 0;

        for(int i=0; i< userNumber.size(); i++) {
            if(computerNumber.get(i).equals(userNumber.get(i)))
                strike++;
        }

        return strike;
    }

    private int countBall(List<Integer> userNumber) {
        int ball = 0;

        for(int i=0; i< userNumber.size(); i++) {
            if(!computerNumber.get(i).equals(userNumber.get(i)) && computerNumber.contains(userNumber.get(i)))
                ball++;
        }

        return ball;
    }
}
