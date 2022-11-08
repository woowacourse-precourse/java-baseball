package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputNumberValidator {

   public static boolean inputNumberTotalCheck(List<Integer> inputNumber){
        return StringIndexOutOfRange(inputNumber)
                && rangeCheck(inputNumber)
                && repeatNumberCheck(inputNumber);
    }

    public static boolean restartOrEndNumberCheck(String inputNumber){
        return inputNumber.equals(Game.RESTART) || inputNumber.equals(Game.GAMEEND);
    }
    public static boolean StringIndexOutOfRange(List<Integer> inputNumber){
        return inputNumber.size() ==  Game.BALLSIZE;
    }

    public static boolean rangeCheck(List<Integer> inputNumber){
        return inputNumber.stream()
                .filter(number -> 1 <= number && number <= 9)
                .count() == Game.BALLSIZE;
    }

    public static boolean repeatNumberCheck(List<Integer> inputNumber) {
        return inputNumber.stream()
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
