package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {

    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = Randoms.pickNumberInRange(start, end);
        }
        return numbers;
    }
}
