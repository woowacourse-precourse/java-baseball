package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBallNumber {

    private static final int BALL_NUMBER_LENGTH = 3;

    String randomNumber = "";

    public String createRandomNumber() {
        while (randomNumber.length() < BALL_NUMBER_LENGTH) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (isContainedNumber(number)) {
                randomNumber = randomNumber.concat(number);
            }
        }
        System.out.println(randomNumber);
        return randomNumber;
    }

    private boolean isContainedNumber(String number) {
        return !randomNumber.contains(number);
    }

    public String clearRandomNumber() {
        randomNumber = "";
        return randomNumber;
    }
}
