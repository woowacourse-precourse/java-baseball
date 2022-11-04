package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static boolean isValidNumbersForGame (String input) {
        if (!isOnlyNumbers(input)) {
            return false;
        }

        if (!hasCorrectSize(input)) {
            return false;
        }

        if (!isAllUnique(input)) {
            return false;
        }

        if (hasZero(input)) {
            return false;
        }

        return true;
    }

    public static boolean isOnlyNumbers (String input) {
        return Pattern.matches("^[0-9]*$", input);
    }

    public static boolean hasCorrectSize (String input) {
        return input.length() == 3;
    }

    public static boolean isAllUnique (String input) {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (Character number : input.toCharArray()) {
            uniqueNumbers.add(number);
        }
        return uniqueNumbers.size() == 3;
    }

    public static boolean hasZero (String input) {
        return Pattern.matches("0", input);
    }

    public static List<Integer> makeAnswer() {
        int numOfPossibleNumbers = 9;
        int[] possibleNumbers = new int[numOfPossibleNumbers];
        for (int i = 0; i < 9; i++) {
            possibleNumbers[i] = i+1;
        }

        int chosenIndex;
        List<Integer> answer = new ArrayList<>();
        for (int times = 1; times <= 3; times++) {
            chosenIndex = Randoms.pickNumberInRange(0, numOfPossibleNumbers - 1);
            answer.add(possibleNumbers[chosenIndex]);
            swap(possibleNumbers, 0, chosenIndex);
            possibleNumbers = subArray(possibleNumbers, 1, numOfPossibleNumbers - 1);
            numOfPossibleNumbers--;
        }

        return answer;
    }

    public static int[] subArray (int[] numbers, int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(i -> numbers[i])
                .toArray();
    }

    public static void swap (int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
