package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputNumberValidator {

   public static boolean inputNumberTotalCheck(String  inputNumber){
        return StringIndexOutOfRange(inputNumber)
                && rangeCheck(inputNumber)
                && repeatNumberCheck(inputNumber);
    }
    public static boolean inputNumberCorrection(String inputNumber){
        return thereIsSpace(inputNumber)
                && thereIsComma(inputNumber);
    }
    public static boolean restartOrEndNumberCheck(String inputNumber){
        return inputNumber.equals(Game.RESTART) || inputNumber.equals(Game.GAMEEND);
    }
    public static boolean StringIndexOutOfRange(String inputNumber){
        return inputNumber.length() ==  Game.BALLSIZE;
    }

    public static boolean rangeCheck(String inputNumber){
        int input = Integer.parseInt(inputNumber);
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(input);
        return inputNumbers.stream()
                .filter(number -> 1 <= number && number <= 9)
                .count() == Game.BALLSIZE;
    }

    public static boolean repeatNumberCheck(String inputNumber) {
        int input = Integer.parseInt(inputNumber);
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.add(input);
        return inputNumbers.stream()
                .distinct()
                .count() == Game.BALLSIZE;
    }

    public static boolean thereIsComma(String  inputNumber){
        return inputNumber.contains(",");
    }

    public static boolean thereIsSpace(String  inputNumber){
        return inputNumber.contains(" ");
    }



}
