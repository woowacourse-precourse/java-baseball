package domain;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_SIZE = 3;

    private static ArrayList<Integer> random_numbers = new ArrayList<>();

    public RandomNumber() {

    }
    public ArrayList<Integer> setRandomNumber(){
        while(random_numbers.size() < NUM_SIZE){
            random_numbers.add(getRandomNumber());
        }
        return random_numbers;
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
