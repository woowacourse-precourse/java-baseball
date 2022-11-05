package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

    private int num = 0;

    public RandomNumber () {setRandomNumber();}

    private void setRandomNumber() {
        for (int i = 0; i < 3; i++) {
            num *= 10;
            num += pickNumberInRange(1, 9);
        }
    }

    public int getRandomNumber() {
        return num;
    }
}
