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
        return Randoms.pickNumberInRange(1, 9);
    }
}
