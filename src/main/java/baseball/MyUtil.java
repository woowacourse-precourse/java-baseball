package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class MyUtil {

    public static String createRandomNumber() {
        boolean[] picked = new boolean[10];
        int firstDigit = Randoms.pickNumberInRange(1, 9);
        picked[firstDigit] = true;

        int secondDigit = -1;
        while (secondDigit == -1 || picked[secondDigit]) {
            secondDigit = Randoms.pickNumberInRange(1, 9);
        }
        picked[secondDigit] = true;

        int thirdDigit = -1;
        while (thirdDigit == -1 || picked[thirdDigit]) {
            thirdDigit = Randoms.pickNumberInRange(1, 9);
        }
        return String.valueOf(firstDigit*100 + secondDigit*10 + thirdDigit);
    }
}
