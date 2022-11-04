package baseball.input;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    String createCorrectInputValue() {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < DIGITS_FOR_THIS_GAME) {
            int randomNumber = pickNumberInRange(1, 9);
            if (stringBuilder.indexOf(String.valueOf(randomNumber)) == -1) {
                stringBuilder.append(randomNumber);
            }
        }

        return stringBuilder.toString();
    }

    String createInputValueMoreThanDigits() {
        StringBuilder stringBuilder = new StringBuilder();
        int range = pickNumberInRange(DIGITS_FOR_THIS_GAME + 1, 9);

        while (stringBuilder.length() < range) {
            int randomNumber = pickNumberInRange(1, 9);
            if (stringBuilder.indexOf(String.valueOf(randomNumber)) == -1) {
                stringBuilder.append(randomNumber);
            }
        }

        return stringBuilder.toString();
    }

    String createInputValueLessThanDigits() {
        StringBuilder stringBuilder = new StringBuilder();
        int range = pickNumberInRange(1, DIGITS_FOR_THIS_GAME - 1);

        while (stringBuilder.length() < range) {
            int randomNumber = pickNumberInRange(1, 9);
            if (stringBuilder.indexOf(String.valueOf(randomNumber)) == -1) {
                stringBuilder.append(randomNumber);
            }
        }

        return stringBuilder.toString();
    }

    String createInputValueContainsZero() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, DIGITS_FOR_THIS_GAME - 1)
                .forEach(i -> stringBuilder.append(pickNumberInRange(1, 9)));

        int idx = pickNumberInRange(0, 2);
        stringBuilder.insert(idx, 0);

        return stringBuilder.toString();
    }

    String createDuplicatedNumber() {
        StringBuilder stringBuilder = new StringBuilder();

        int numberForDuplication = pickNumberInRange(1, 9);
        int duplicationCount = pickNumberInRange(2, DIGITS_FOR_THIS_GAME);
        int nonDuplicationCount = DIGITS_FOR_THIS_GAME - duplicationCount;

        System.out.println("duplicationCount = " + duplicationCount);
        System.out.println("nonDuplicationCount = " + nonDuplicationCount);

        IntStream.range(0, duplicationCount)
                .forEach(i -> stringBuilder.append(numberForDuplication));

        if (nonDuplicationCount != 0) {
            IntStream.range(0, nonDuplicationCount)
                    .forEach(i -> stringBuilder.append(pickNumberInRange(1, 9)));
        }

        return stringBuilder.toString();
    }

    String createNegativeNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-");

        IntStream.range(0, DIGITS_FOR_THIS_GAME - 1)
                .forEach(i -> stringBuilder.append(Randoms.pickNumberInRange(1, 9)));

        return stringBuilder.toString();
    }
}
