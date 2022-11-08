package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {
    static List<Integer> createAnswer(){
        List<Integer> answerList = new ArrayList<>(3); //allocate exact capacity to list
        int randomNum = 0;
        while (answerList.size() < 3){
            randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNum)) {
                answerList.add(randomNum);
            }
        }

        return answerList;
    }

    static void checkValidInput(String input){
        int len = input.length();
        if (len != 3){
            throw new IllegalArgumentException("Invalid input");
        }

        char check;
        for (int i = 0; i < len; i++) {
            check = input.charAt(i);
            if (check < '1' || check > '9') {
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }

    static String inputAnswer(){
        String inputString = Console.readLine();

        try {
            checkValidInput(inputString);
        } catch(Exception e){
            e.printStackTrace();
        }

        return inputString;
    }

    static List<Integer> castToInteger(String str){
        List<Integer> inputList = new ArrayList<>(3);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            inputList.add(Character.getNumericValue(str.charAt(i)));
        }
        return inputList;
    }

    public static void main(String[] args) {

        String inputString = inputAnswer();
        List<Integer> isStrike = castToInteger(inputString);
        List<Integer> Answer = createAnswer();

        //for debugging
        System.out.print("Input: ");
        for (Integer i : isStrike) {
            System.out.print(i);
        }
        System.out.println();
        System.out.print("Answer: ");
        for (Integer i : Answer) {
            System.out.print(i);
        }
        System.out.println();
        //
    }
}
