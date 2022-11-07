package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumberMaker {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;
    private static final int BALL_LENGTH = 3;


    static ArrayList<Integer> computer() {
        ArrayList<Integer> computerNumber = new ArrayList<>(BALL_LENGTH);
        while (computerNumber.size() < BALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
