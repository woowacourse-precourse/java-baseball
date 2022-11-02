package baseball.game.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final List<Integer> randomNumber;
    private final int SIZE=3;
    private final int START_RANGE=1;
    private final int END_RANGE=9;
    public RandomNumber(){
        randomNumber=randomNumber();
    }
    public List<Integer> getRandomNumber(){
        return randomNumber;
    }
    private List<Integer> randomNumber(){
        List<Integer> randomNumber=new ArrayList<>();
        while(randomNumber.size() <SIZE) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        return randomNumber;
    }
}
