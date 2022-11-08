package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {

    static List<Integer> inputAnswer(){
        List<Integer> inputList;
        Integer[] inputArray = new Integer[3];
        String inputString = Console.readLine();
        String[] parsedString = inputString.split(" ");

        //for debugging
        System.out.println(inputString);
        for (String str : parsedString) {
            System.out.println(str);
        }
        System.out.println(parsedString.length);
        //

        for (int i = 0; i < 3; i++) {
            inputArray[i] = Integer.parseInt(parsedString[i]);
        }
        inputList = Arrays.asList(inputArray);

        return inputList;
    }

    public static void main(String[] args) {

        List<Integer> isStrike = inputAnswer();

        //for debugging
        for (Integer i : isStrike) {
            System.out.println("(" + i + ")");
        }
        //
    }
}
