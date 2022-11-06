package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    int fullNumber;
    int firstDigit;
    int secondDigit;
    int thirdDigit;

    public RandomNumber() {
        generateFirstRandomDigit();
        generateSecondRandomDigit();
        generateThirdRandomDigit();
    }

    public int generateFirstRandomDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public int generateSecondRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (randomNumber == firstDigit) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    public int generateThirdRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (randomNumber == firstDigit || randomNumber == secondDigit) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }
}
