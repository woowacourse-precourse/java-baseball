package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    static final int MINIMUM_RANGE = 0;
    static final int MAXIMUM_RANGE = 9;
    static final int RANDOM_NUMBER_SIZE = 3;

    private int strike;
    private int ball;

    private List<Integer> targetRandomNumber = new ArrayList<>();

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public List<Integer> getTargetRandomNumber() {
        return targetRandomNumber;
    }

    public void setTargetRandomNumber(List<Integer> targetRandomNumber) {
        this.targetRandomNumber = targetRandomNumber;
    }

    public Computer() {
        setStrike(0);
        setBall(0);
    }

    public void pickRandomNumber() {
        while (targetRandomNumber.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (!targetRandomNumber.contains(randomNumber)) {
                targetRandomNumber.add(randomNumber);
            }
        }
    }

    public void giveHintToUser() {
        if (isNothing()) {
            System.out.println("낫싱");
        }
        printStrikeBall();
    }

    private void printStrikeBall() {
        if (this.getBall() > 0) {
            System.out.print(this.getBall() + "볼 ");
        }
        if (this.getStrike() > 0) {
            System.out.print(this.getStrike() + "스트라이크 ");
        }
        System.out.println();
    }

    public boolean isThreeStrike() {
        if (this.getStrike() == 3) {
            return true;
        }
        return false;
    }

    private boolean isNothing() {
        if (this.getStrike() == 0 && this.getBall() == 0) {
            return true;
        }
        return false;
    }

    public void calculateStrikeBall(List<Integer> inputList) {
        setBall(0);
        setStrike(0);
        for (int i = 0; i < 3; i++) {
            int inputEachNumber = inputList.get(i);
            if (inputEachNumber == targetRandomNumber.get(i)) {
                strike++;
            } else if (targetRandomNumber.contains(inputEachNumber)) {
                ball++;
            }
        }
    }
}
