package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.mockito.internal.runners.InternalRunner;

public class Computer {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int SIZE = 3;

    boolean[] collection;
    List<Integer> randomNumbers;

    public Computer() {
        collection = new boolean[MAXIMUM_NUMBER - MINIMUM_NUMBER + 1];
        Arrays.fill(collection, false);
        randomNumbers = null;
    }

    public void createDifferentRandomNumbers() {
        randomNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, SIZE);
        initCollection();
    }

    private void initCollection() {
        Arrays.fill(collection, false);
        for (Integer randomNumber :
                randomNumbers) {
            collection[randomNumber - MINIMUM_NUMBER] = true;
        }
    }
}
