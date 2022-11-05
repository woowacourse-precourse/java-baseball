package features;


import static extract.Validation.*;
import static java.lang.String.valueOf;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Input extends Exception{

    private static Map<Integer, Character> userRepository = new HashMap<>();
    private static java.lang.IllegalArgumentException IllegalArgumentException;


    // 입력 기능
    public static Map<Integer, Character> inputUserNumber() {

        String userLine = Console.readLine();


        try {
            validationCheck(userLine);
        }catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.toString();

        }

        String numberToString = valueOf(userLine);

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
