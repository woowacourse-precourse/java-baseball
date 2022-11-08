package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_SIZE = 3;

    private int[] computer_numbers;

    public RandomNumber() {

    }

    public int[] getNumbers(){
        return this.computer_numbers;
    }

    public void setRandomNumber(){
        Set<Integer> random_number_set = new HashSet<>();

        while(random_number_set.size() < NUM_SIZE){
            random_number_set.add(getRandomNumber());
        }
        this.computer_numbers = convertSetToArray(random_number_set);
    }

    private int[] convertSetToArray(Set<Integer> set){
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
