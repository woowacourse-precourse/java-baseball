package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNum;
    private int strike;
    private int ball;
    private boolean nothing;

    public List<Integer> generateRandomNumList(){
        this.randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
        return this.randomNum;
    }

    private void checkStrike(List<Integer> usersNum) {
        for (int i = 0; i < usersNum.size(); i++) {
            if (randomNum.get(i) == usersNum.get(i)) {
                this.strike++;
            }
        }
    }

    private void checkBall(List<Integer> usersNum) {
        for (int index = 0; index < randomNum.size(); index++) {
            Integer computerPerNum = randomNum.get(index);
            Integer userPerNum = usersNum.get(index);
            if (usersNum.contains(computerPerNum) && userPerNum != computerPerNum) {
                ball++;
            }
        }
    }

    private void checkNothing(){
        int sumStrikeAndBall = strike + ball;
        if (sumStrikeAndBall == 0) {
            nothing=true;
        }
    }

    private boolean isThreeStrike(){
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }



}
