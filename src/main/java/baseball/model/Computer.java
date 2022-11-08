package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static int[] getComputerNumber(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = uniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int uniqueRandomNumber(int[] numbers, int start, int end, int i) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        while (!uniqueNumber(numbers, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }
        return randomNumber;
    }

    private static Boolean uniqueNumber(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
