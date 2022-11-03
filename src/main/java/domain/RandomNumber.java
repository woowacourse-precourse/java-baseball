package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_SIZE = 3;

    public RandomNumber() {

    }
    public void setRandomNumber(){
        Set<Integer> random_number_set = new HashSet<>();

        while(random_number_set != null && random_number_set.size() < NUM_SIZE){
            random_number_set.add(getRandomNumber());
        }
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
