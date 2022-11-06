package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayer {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int SIZE = 3;

    public boolean[] collection;
    public int[] numbers;

    public GamePlayer() {
        collection = new boolean[MAXIMUM_NUMBER - MINIMUM_NUMBER + 1];
        Arrays.fill(collection, false);
        numbers = new int[SIZE];
    }

    public void saveNumbers(String str) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (str.charAt(i) - '0');
        }

        Arrays.fill(collection, false);
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            collection[number - MINIMUM_NUMBER] = true;
        }
    }
}
