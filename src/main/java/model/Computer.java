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

    public void setCollection(boolean[] collection) {
        this.collection = collection;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public Computer() {
        collection = new boolean[MAXIMUM_NUMBER - MINIMUM_NUMBER + 1];
        Arrays.fill(collection, false);
        randomNumbers = new ArrayList<>();
    }

    /**
     * 서로 다른 SIZE 크기의 자리수 생성 및 해당 숫자들을 collection에 표시한다.
     */
    public void createDifferentRandomNumbers() {
        randomNumbers.clear();
        while (randomNumbers.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        initCollection();
    }

    /**
     * 직접 서로 다른 숫자를 지정하였을 경우 사용한다. collection을 다시 표시한다.
     */
    public void initCollection() {
        Arrays.fill(collection, false);
        for (Integer randomNumber : randomNumbers) {
            collection[randomNumber - MINIMUM_NUMBER] = true;
        }
    }
}
