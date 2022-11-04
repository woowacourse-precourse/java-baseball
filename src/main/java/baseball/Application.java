package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

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
