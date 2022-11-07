package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int SIZE = 3;

    private boolean[] collection;
    private List<Integer> randomNumbers;

    public boolean[] getCollection() {
        return collection;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public Computer() {
        collection = new boolean[MAXIMUM_NUMBER - MINIMUM_NUMBER + 1];
        Arrays.fill(collection, false);
        randomNumbers = new ArrayList<>();
    }

    public void createDifferentRandomNumbers() {
        randomNumbers.clear();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        initCollection();
    }

    private void initCollection() {
        Arrays.fill(collection, false);
        for (Integer randomNumber : randomNumbers) {
            collection[randomNumber - MINIMUM_NUMBER] = true;
        }
    }
}
