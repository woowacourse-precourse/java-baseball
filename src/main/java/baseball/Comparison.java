package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparison {
    static final int NUMBER_OF_DIGIT = 3;

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

    public static int getStrikeCount(int randomNumber, int userInputNumber){
        int strikeCount = 0;
        List<Integer> randomNumberList = numberToList(randomNumber);
        List<Integer> userInputNumberList = numberToList(userInputNumber);

        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            if(randomNumberList.get(i) == userInputNumberList.get(i)){
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
