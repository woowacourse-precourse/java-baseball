package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputNumberValidator {
    /*
    - 사용자 입력 숫자사이에 , 가 들어가는 경우
    - 사용자가 숫자를 3자리 이상 입력했을 경우
    - 사용자가 숫자를 1-9외 범위로 입력했을 경우
    - 사용자 입력 숫자 사이에 공백이 있을 경우
     */




    public static boolean inputNumberCorrection(String inputNumber){
        return thereIsSpace(inputNumber)
                && thereIsComma(inputNumber);
    }
    public static boolean restartOrEndNumberCheck(String inputNumber){
        return inputNumber.equals("1") || inputNumber.equals("2");
    }
    public static boolean StringIndexOutOfRange(String inputNumber){
        return inputNumber.length() == 3;
    }

    public static boolean rangeCheck(String inputNumber){
        int input = Integer.parseInt(inputNumber);
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(input);
        return inputNumbers.stream()
                .filter(number -> 1 <= number && number <= 9)
                .count() == 3;
    }

    public static boolean repeatNumberCheck(String inputNumber) {
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add(inputNumber);
        return inputNumbers.stream()
                .distinct()
                .count() == 3;
    }

    public static boolean thereIsComma(String inputNumber){
        return inputNumber.contains(",");
    }

    public static boolean thereIsSpace(String inputNumber){
        return inputNumber.contains(" ");
    }



}
