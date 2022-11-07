package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Computer {
    private final static int MIN_NUM = 1;
    private final static int MAX__NUM = 9;
    private final static int MAX_NUMBER_SIZE = 3;
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
        randomNum = new ArrayList<>();
        HashSet<Integer> NotDuplicateHashset = new HashSet<>();
        while (randomNum.size() < MAX_NUMBER_SIZE) {
            int generatedNum = Randoms.pickNumberInRange(MIN_NUM, MAX__NUM);
            addNotDuplicateNumToList(NotDuplicateHashset,generatedNum);
        }

        return this.randomNum;
    }

    private void addNotDuplicateNumToList(HashSet<Integer> hashSet,int num) {
        if (!hashSet.contains(num)) {
            randomNum.add(num);
            hashSet.add(num);
        }
    }

    public Computer compareUsersNum(List<Integer> usersNum) {
        checkStrike(usersNum);
        checkBall(usersNum);
        checkNothing();
        if (!isCorrectCompute()) {
            throw new RuntimeException("컴퓨터의 사용자와의 숫자비교로직이 잘못처리되었습니.");
        }

        return this;
    }

    public void resetCompareComponent() {
        this.strike=0;
        this.ball=0;
        this.nothing=false;
    }


    private void checkStrike(List<Integer> usersNum) {
        for (int i = 0; i < usersNum.size(); i++) {
            if (randomNum.get(i) == usersNum.get(i)) {
                this.strike++;
            }
        }
    }

    private void checkBall(List<Integer> usersNum) {
        HashSet<Integer> usersHashSet = new HashSet<>(Arrays.asList(usersNum.get(0), usersNum.get(1), usersNum.get(2)));

        for (int index = 0; index < randomNum.size(); index++) {
            Integer computerPerNum = randomNum.get(index);
            Integer userPerNum = usersNum.get(index);
            if (usersHashSet.contains(computerPerNum) && userPerNum != computerPerNum) {
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

    public boolean isThreeStrike(){
        if (strike == 3 && (ball == 0 && nothing == false)) {
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
