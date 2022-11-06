package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Application {
    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static String evaluationToString (List<Integer> evaluation) {
        StringBuilder sb = new StringBuilder();

        if ( hasBall(evaluation) ) {
            sb.append(evaluation.get(BALL)).append("볼 ");
        }

        if ( hasStrike(evaluation) ) {
            sb.append(evaluation.get(STRIKE)).append("스트라이크");
        }

        if ( sb.length() == 0 ) {
            sb.append("낫싱");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static boolean hasBall (List<Integer> evaluation) {
        return evaluation.get(BALL) > 0;
    }

    public static boolean hasStrike (List<Integer> evaluation) {
        return evaluation.get(STRIKE) > 0;
    }

    /**
     * Return list of ball and strike count.
     * First element of the list (index 0) is ball count and second one (index 1) is strike count.
     *
     * @param guess list of numbers to be evaluated.
     * @param answer answer number list of the 369 game.
     * @return list of ball and strike count in this order.
     */
    public static List<Integer> evaluateGuess (List<Integer> guess, List<Integer> answer) {
        int ballCount = countBall(guess, answer);
        int strikeCount = countStrike(guess, answer);
        return Arrays.asList(ballCount, strikeCount);
    }

    public static int countBall (List<Integer> guess, List<Integer> answer) {
        int countOfCommonNumbers = countCommonNumber(guess, answer);
        int countOfNumbersInSamePosition = countNumbersInSamePosition(guess, answer);
        return countOfCommonNumbers - countOfNumbersInSamePosition;
    }

    public static int countStrike (List<Integer> guess, List<Integer> answer) {
        return countNumbersInSamePosition(guess, answer);
    }

    public static int countCommonNumber (List<Integer> guess, List<Integer> answer) {
        return (int) guess.stream().filter(answer::contains).count();

    }

    public static int countNumbersInSamePosition (List<Integer> guess, List<Integer> answer) {
        return (int) IntStream.range(0, 3)
                .filter(i -> Objects.equals(guess.get(i), answer.get(i)))
                .count();
    }

    public static List<Integer> stringToNumberList (String numbersInString) {
        List<Integer> numberList = new ArrayList<>();
        int number;
        for ( int i = 0; i < 3; i++) {
            number = numbersInString.charAt(i) - '0';
            numberList.add(number);
        }
        return numberList;
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
