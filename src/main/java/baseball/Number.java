package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    public static final int NUMBERS_SIZE = 3;

    public static List<Integer> getOpponentNumbersInList() {
        List<Integer> opponentNumbers = new ArrayList<>();
        while (opponentNumbers.size() < NUMBERS_SIZE) {
            int readNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addNumber(opponentNumbers, readNumber);
        }
        return opponentNumbers;
    }

    public static void addNumber(List<Integer> numbersList, int number) {
        if (!isDuplicated(numbersList, number)) {
            numbersList.add(number);
        }
    }

    public static boolean isDuplicated(List<Integer> numbersList, int number) {
        return numbersList.contains(number);
    }
}
