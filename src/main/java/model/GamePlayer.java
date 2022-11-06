package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayer {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int SIZE = 3;

    public int[] numbers;

    public GamePlayer() {
        numbers = new int[SIZE];
    }

    public void saveNumbers(String str) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (str.charAt(i) - '0');
        }
    }
}
