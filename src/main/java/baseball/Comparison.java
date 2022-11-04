package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparison {
    static int numberOfDigit;
    static List<Integer> randomNumberList = new ArrayList<>();
    static List<Integer> userInputNumberList = new ArrayList<>();

    public Comparison(int randomNumber, int userInputNumber, final int NUMBER_OF_DIGIT) {
        this.randomNumberList = numberToList(randomNumber);
        this.userInputNumberList = numberToList(userInputNumber);
        this.numberOfDigit = NUMBER_OF_DIGIT;
    }

    public static List<Integer> numberToList(int number) {
        List<Integer> numberList = new ArrayList<>();
        String stringNumber = String.valueOf(number);
        int numberLength = stringNumber.length();

        for (int i = 0; i < numberLength; i++) {
            int digit = stringNumber.charAt(i) - '0';
            numberList.add(digit);
        }

        return numberList;
    }

    public static int getStrikeCount() {
        int strikeCount = 0;

        for (int i = 0; i < numberOfDigit; i++) {
            if (randomNumberList.get(i) == userInputNumberList.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int getBallCount() {
        int ballCount = 0;

        for (int i = 0; i < numberOfDigit; i++) {
            for (int j = 0; j < numberOfDigit; j++) {
                ballCount += compareDigit(i, j);
            }
        }

        return ballCount;
    }

    public static int compareDigit(int index1, int index2) {
        int randomNumberDigit = randomNumberList.get(index1);
        int userInputNumberDigit = userInputNumberList.get(index2);

        if (index1 != index2 && randomNumberDigit == userInputNumberDigit) {
            return 1;
        }
        return 0;
    }
}
