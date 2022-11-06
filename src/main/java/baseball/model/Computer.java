package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNum;
    private int strike;
    private int ball;
    private boolean nothing;

    public Computer() {
        this.randomNum = new ArrayList<>();
        this.strike=0;
        this.ball=0;
        this.nothing=false;
    }

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

    public Computer compareUsersNum(List<Integer> usersNum) {
        checkStrike(usersNum);
        checkBall(usersNum);
        checkNothing();
        if (!isCorrectCompute()) {
            throw new RuntimeException("컴퓨터의 사용자와의 숫자비교로직이 잘못처리되었습니다.");
        }

        return this;
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

    private boolean isCorrectCompute(){
        int sumStrikeAndBall = strike + ball;
        if (sumStrikeAndBall > 3 || sumStrikeAndBall < 0) {
            return false;
        } else if (strike == 2 && ball == 1) {
            return false;
        } else {
            return true;
        }
    }


    public List<Integer> getRandomNum() {
        return randomNum;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean getNothing() {
        return nothing;
    }
}
