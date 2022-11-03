package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomBallNumber {

    private static final int BALL_NUMBER_LENGTH = 3;

    String randomNum = "";
    public String createRandomNum() {
        while(randomNum.length() < BALL_NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(!randomNum.contains(randomNumber)) {
                randomNum = randomNum.concat(randomNumber);
            }
        }
        System.out.println(randomNum);
        return randomNum;
    }

    public String clearRandomNum() {
        randomNum = "";
        return randomNum;
    }
}
