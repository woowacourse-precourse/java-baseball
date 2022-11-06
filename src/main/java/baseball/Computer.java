package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static String Number() {
        String computerNumber = "";

        do {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));

            if (!computerNumber.contains(randomNumber)) {
                computerNumber += randomNumber;
            }
        } while (computerNumber.length() != DIGIT_NUMBER);

        return computerNumber;
    }
}
