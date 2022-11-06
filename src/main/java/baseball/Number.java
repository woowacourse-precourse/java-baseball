package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int GAME_NUMBER_SIZE = 3;

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    
    private List<Integer> gameNumber;
    
    public Number() {}
    
    public List<Integer> getGameNumber() {
        return this.gameNumber;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
    
    public void createRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < GAME_NUMBER_SIZE) {
            int randomNumber = getRandomNumber();
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        this.gameNumber = computerNumber;
    }
}