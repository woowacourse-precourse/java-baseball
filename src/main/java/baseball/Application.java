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

    static void checkInputLength(String input){
        int len = input.length();
        if (len != 3){
            throw new IllegalArgumentException("Invalid input");
        }
    }

    static void checkInputRange(String input){
        char check;
        int len = input.length();
        for (int i = 0; i < len; i++) {
            check = input.charAt(i);
            if (check < '1' || check > '9') {
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }

    static void checkRedundancy(String input){
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if (first == second) {
            throw new IllegalArgumentException("Same number cannot be input");
        } else if (first == third) {
            throw new IllegalArgumentException("Same number cannot be input");
        } else if (second == third) {
            throw new IllegalArgumentException("Same number cannot be input");
        }
    }

    static void checkValidInput(String input){
        checkInputLength(input);
        checkInputRange(input);
        checkRedundancy(input);
    }

    static String inputAnswer(){
        System.out.print("숫자를 입력해주세요 : ");
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
        List<Integer> thrownBalls = castToInteger(inputString);
        List<Integer> Answer = createAnswer();

        //for debugging
        System.out.print("Input: ");
        for (Integer i : thrownBalls) {
            System.out.print(i);
        }
        System.out.println();
        System.out.print("Answer: ");
        for (Integer i : Answer) {
            System.out.print(i);
        }
        System.out.println();
        //

        while (true){
            break;
        }
    }
}
