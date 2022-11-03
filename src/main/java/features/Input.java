package features;


import static features.Validation.*;
import static java.lang.String.valueOf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Input {
    private static Map<Integer, Character> userRepository = new HashMap<>();

    // 입력 기능
    public static Map<Integer, Character> input() {

        Scanner inputNumbers = new Scanner(System.in);
        int threeDigitsNumber = inputNumbers.nextInt();

        if ( ! validationCheck(threeDigitsNumber) ) { }

        String numberToString = valueOf(threeDigitsNumber);

        char indexZero = getIndex(numberToString, 0);
        char indexOne = getIndex(numberToString, 1);
        char indexTwo = getIndex(numberToString, 2);

        getPut(0, indexZero);
        getPut(1, indexOne);
        getPut(2, indexTwo);

        return userRepository;
    }

    private static char getIndex(String numberToString, int index) {
        return numberToString.charAt(index);
    }

    private static Character getPut(int key, char indexValue) {
        return userRepository.put(key, indexValue);
    }
}
