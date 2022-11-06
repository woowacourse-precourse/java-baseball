package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    int fullNumber;
    int firstDigit;
    int secondDigit;
    int thirdDigit;

    public RandomNumber() {
    }

    public int generateFirstRandomDigit() {
        return firstDigit = Randoms.pickNumberInRange(1, 9);
    }

    public int generateSecondRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (randomNumber == firstDigit) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return secondDigit = randomNumber;
    }
}
