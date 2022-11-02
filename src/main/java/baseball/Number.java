package baseball;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

public class Number {

    private static final int SIZE_OF_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int[] digits;

    public int[] getDigits(){
        return this.digits;
    }

    private void setDigits(String input) {

    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void setRandomNumber() {
        ArrayList<Integer> randomList = new ArrayList<>();

        while(randomList.size() != SIZE_OF_NUMBER) {
            randomList.add(getRandomNumber());
        }
        digits = convertIntegerSetToIntArray(randomList);
    }

    private int[] convertIntegerSetToIntArray (ArrayList<Integer>  randomList) {
        return randomList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
