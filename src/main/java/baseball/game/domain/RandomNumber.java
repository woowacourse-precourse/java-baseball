package baseball.game.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final List<Integer> randomNumber;
    public RandomNumber(Integer size,Integer startRange,Integer endRange){
        randomNumber=randomNumber(size, startRange, endRange);
    }
    public List<Integer> getRandomNumber(){
        return randomNumber;
    }
    private List<Integer> randomNumber(Integer size,Integer startRange,Integer endRange){
        List<Integer> randomNumber=new ArrayList<>();
        while(randomNumber.size() <size) {
            int num = Randoms.pickNumberInRange(startRange, endRange);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        return randomNumber;
    }
}
