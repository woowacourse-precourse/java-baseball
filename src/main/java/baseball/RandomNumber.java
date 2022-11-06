package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;

    int fullNumber;
    int firstDigit;
    int secondDigit;
    int thirdDigit;

    public RandomNumber() {
        this.firstDigit = generateFirstRandomDigit();
        this.secondDigit = generateSecondRandomDigit();
        this.thirdDigit = generateThirdRandomDigit();
        this.fullNumber = combineEachDigit();
    }

    public int generateFirstRandomDigit() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }

    public int generateSecondRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
        while (randomNumber == firstDigit) {
            randomNumber = Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
        }
        return randomNumber;
    }

    public int generateThirdRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
        while (randomNumber == firstDigit || randomNumber == secondDigit) {
            randomNumber = Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
        }
        return randomNumber;
    }

    public int combineEachDigit() {
        return firstDigit * 100 + secondDigit * 10 + thirdDigit;
    }
}
