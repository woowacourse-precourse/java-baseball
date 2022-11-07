package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final int NUM_MIN_VALUE = 1;
    public static final int NUM_MAX_VALUE = 9;
    public static final int NUM_LENGTH = 3;

    public List<Integer> createNumber(){
        List<Integer> randomNumbers = new ArrayList<>();

        while(randomNumbers.size() < NUM_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(NUM_MIN_VALUE, NUM_MAX_VALUE);

            if(duplicateCheck(randomNumbers, randomNumber)==false)
                randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public boolean duplicateCheck (List<Integer> numberList, int randomNumber){
        return numberList.contains(randomNumber);
    }
}
