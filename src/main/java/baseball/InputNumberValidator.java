package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputNumberValidator {

    public static boolean inputNumberTotalCheck(int inputNumber){
        return StringIndexOutOfRange(inputNumber)
                && rangeCheck(inputNumber)
                && repeatNumberCheck(inputNumber);
    }
    public static boolean inputNumberCorrection(int inputNumber){
        return thereIsSpace(inputNumber)
                && thereIsComma(inputNumber);
    }
    public static boolean restartOrEndNumberCheck(int inputNumber){
        return inputNumber == Game.RESTART || inputNumber == Game.GAMEEND;
    }
    public static boolean StringIndexOutOfRange(int inputNumber){
        String input = String.valueOf(inputNumber);
        return inputNumber == Game.BALLSIZE;
    }

    public static boolean rangeCheck(int inputNumber){
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(inputNumber);
        return inputNumbers.stream()
                .filter(number -> 1 <= number && number <= 9)
                .count() == Game.BALLSIZE;
    }

    public static boolean repeatNumberCheck(int inputNumber) {
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(inputNumber);
        return inputNumbers.stream()
                .distinct()
                .count() == Game.BALLSIZE;
    }

    public static boolean thereIsComma(int inputNumber){
        String input = String.valueOf(inputNumber);
        return input.contains(",");
    }

    public static boolean thereIsSpace(int inputNumber){
        String input = String.valueOf(inputNumber);
        return input.contains(" ");
    }



}
