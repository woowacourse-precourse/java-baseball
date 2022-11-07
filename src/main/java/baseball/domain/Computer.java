package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Setting.LENGTH;

public class Computer {
    private List<Integer> computerNumber = new ArrayList<>();

    public void initComputerNumber() {
        computerNumber.clear();

        while(computerNumber.size() < LENGTH) {
            insertRandomNumber();
        }
    }

    private void insertRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public int countStrike(List<Integer> userNumber) {
        int strike = 0;

        for(int i=0; i< userNumber.size(); i++) {
            if(isStrike(i, userNumber.get(i))) strike++;
        }

        return strike;
    }

    private boolean isStrike(int index, int userNumber) {
        if(computerNumber.get(index).equals(userNumber))
            return true;
        return false;
    }

    public int countBall(List<Integer> userNumber) {
        int ball = 0;

        for(int i=0; i< userNumber.size(); i++) {
            if(isBall(i, userNumber.get(i))) ball++;
        }

        return ball;
    }

    private boolean isBall(int index, int userNumber) {
        if(!computerNumber.get(index).equals(userNumber) && computerNumber.contains(userNumber))
            return true;
        return false;
    }
}
