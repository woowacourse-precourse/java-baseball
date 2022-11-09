package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumber {
    public static ArrayList<Integer> getRandomNumber(int size, int start, int end){
        ArrayList<Integer> randomNumberArray = new ArrayList<>(size);

        while (randomNumberArray.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            addUniqueNumber(randomNumberArray, randomNumber);
        }

        return randomNumberArray;
    }

    private static void addUniqueNumber(ArrayList<Integer> list, int number){
        if (!list.contains(number)) {
            list.add(number);
        }
    }
}
