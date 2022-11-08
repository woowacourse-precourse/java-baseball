package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {

    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueNumber(numbers, i, start, end);
        }
        return numbers;
    }

    private static int getUniqueNumber(int[] numbers, int index, int start, int end) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        while (!isUnique(numbers, index, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] numbers, int index, int randomNumber) {
        for (int i = 0; i < index; i++) {
            if (numbers[i] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
