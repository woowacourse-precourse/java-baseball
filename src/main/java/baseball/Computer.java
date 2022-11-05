package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BASEBALL_GAME_DIGIT = 3;
    private final List<Character> baseballNumber = new ArrayList<>();

    public List<Character> getBaseballNumber() {
        return baseballNumber;
    }

    public void makeRandomNumber(){
        while (baseballNumber.size() < BASEBALL_GAME_DIGIT) {
            addRandomNumber();
        }
    }

    private void addRandomNumber(){
        char randomNumber = Character.forDigit((Randoms.pickNumberInRange(1, 9)), 10);
        if (!baseballNumber.contains(randomNumber)) {
            baseballNumber.add(randomNumber);
        }
    }


}
